package yuki.spring.collection;

import java.sql.*;
import java.util.*;

//웹 컨테이너(WAS)가 실행되면서 connection 객체를 미리 pool에 생성합니다.
public final class ConnectionPool {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// 사용하지 않은 커넥션 즉, 초기 커넥션을 저장하는 변수
	private ArrayList<Connection> free;
	private ArrayList<Connection> used;
	// DB설정
	// 데이터베이스는 오라클을 기준으로 합니다.
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "mytest";
	private String password = "mytest";
	// 커넥션을 계속해서 재사용하기 때문에 생성되는 커넥션 수를 제한적으로 설정함
	private int initialCons = 10; // 최초로 초기 커넥션수
	private int maxCons = 20; // 최대 커넥션수
	private int numCons = 0; // 총 Connection 수
	// 커넥션풀
	private static ConnectionPool cp;

	public static ConnectionPool getInstance() {
		try {
			//커넥션 풀 객체는 Singleton 패턴을 적용합니다.
			if (cp == null) { // 커넥션풀이 없다면 새로운 커넥션풀을 만든다
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		// 커넥션풀을 반환해준다
		return cp;
	}

	private ConnectionPool() throws SQLException {
		// 초기 커넥션 개수를 각각의 ArrayList에 저장할 수 있도록 초기 커넥션 수만큼 ArrayList 생성
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons);
		// initialCons 수만큼 Connection 생성(free)
		while (numCons < initialCons) {
			addConnection();
		}
	}

	// free에 커넥션 객체를 저장함
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}

	// 새로운 커넥션 객체를 생성함
	// 객체의 생성
	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("About to connect to " + con);
		// 컨넥션 생성될 때 마다 숫자 증가
		++numCons; 
		return con;
	}

	// free에 있는 커넥션을 used로 옮기는 작업 => free--->used
	public synchronized Connection getConnection() throws SQLException {
		// free에 Connection이 없으면 massCons만큼 Connection을 더 생성한다.
		if (free.isEmpty()) {
			while (numCons < maxCons) {
				addConnection();
			}
		}
		Connection _con;
		_con = free.get(free.size() - 1);
		free.remove(_con);
		used.add(_con);
		// 커넥션을 반환
		return _con; 
	}

	// used에 있는 커넥션을 free로 반납함
	// 자원의 반납 처리
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if (used.contains(_con)) { // 커넥션이 used에 포함되어 있다면
			used.remove(_con); // used에서 그 커넥션을 꺼내고
			numCons--; // used에 수를 줄인다
			flag = true;
		} else {
			throw new SQLException("ConnectionPool" + "에 있지 않네요!!");
		}
		try {
			if (flag) {
				free.add(_con);
				numCons++; // free에 커넥션을 반환하고 수를 늘린다
			} else {
				_con.close(); // 커넥션을 닫는다
			}
		} catch (SQLException e) {
			try {
				_con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	// 모든 Connection 자원을 반납함
	public void closeAll() { 
		// used에 있는 커넥션을 모두 삭제해 버림
		for (int i = 0; i < used.size(); i++) {
			Connection _con = (Connection) used.get(i);
			used.remove(i--);
			try {
				_con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// free에 있는 커넥션을 모두 삭제해 버림
		for (int i = 0; i < free.size(); i++) {
			Connection _con = (Connection) free.get(i);
			free.remove(i--);
			try {
				_con.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

	}

	// 현재 최대 커넥션을 수를 반환
	public int getMaxCons() {
		return maxCons;
	}

	// 현재 쓸 커넥션 번호를 반환
	public int getNumCons() {
		return numCons;
	}
}
