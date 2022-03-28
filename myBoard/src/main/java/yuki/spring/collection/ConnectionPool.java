package yuki.spring.collection;

import java.sql.*;
import java.util.*;

//�� �����̳�(WAS)�� ����Ǹ鼭 connection ��ü�� �̸� pool�� �����մϴ�.
public final class ConnectionPool {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// ������� ���� Ŀ�ؼ� ��, �ʱ� Ŀ�ؼ��� �����ϴ� ����
	private ArrayList<Connection> free;
	private ArrayList<Connection> used;
	// DB����
	// �����ͺ��̽��� ����Ŭ�� �������� �մϴ�.
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "mytest";
	private String password = "mytest";
	// Ŀ�ؼ��� ����ؼ� �����ϱ� ������ �����Ǵ� Ŀ�ؼ� ���� ���������� ������
	private int initialCons = 10; // ���ʷ� �ʱ� Ŀ�ؼǼ�
	private int maxCons = 20; // �ִ� Ŀ�ؼǼ�
	private int numCons = 0; // �� Connection ��
	// Ŀ�ؼ�Ǯ
	private static ConnectionPool cp;

	public static ConnectionPool getInstance() {
		try {
			//Ŀ�ؼ� Ǯ ��ü�� Singleton ������ �����մϴ�.
			if (cp == null) { // Ŀ�ؼ�Ǯ�� ���ٸ� ���ο� Ŀ�ؼ�Ǯ�� �����
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		// Ŀ�ؼ�Ǯ�� ��ȯ���ش�
		return cp;
	}

	private ConnectionPool() throws SQLException {
		// �ʱ� Ŀ�ؼ� ������ ������ ArrayList�� ������ �� �ֵ��� �ʱ� Ŀ�ؼ� ����ŭ ArrayList ����
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons);
		// initialCons ����ŭ Connection ����(free)
		while (numCons < initialCons) {
			addConnection();
		}
	}

	// free�� Ŀ�ؼ� ��ü�� ������
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}

	// ���ο� Ŀ�ؼ� ��ü�� ������
	// ��ü�� ����
	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("About to connect to " + con);
		// ���ؼ� ������ �� ���� ���� ����
		++numCons; 
		return con;
	}

	// free�� �ִ� Ŀ�ؼ��� used�� �ű�� �۾� => free--->used
	public synchronized Connection getConnection() throws SQLException {
		// free�� Connection�� ������ massCons��ŭ Connection�� �� �����Ѵ�.
		if (free.isEmpty()) {
			while (numCons < maxCons) {
				addConnection();
			}
		}
		Connection _con;
		_con = free.get(free.size() - 1);
		free.remove(_con);
		used.add(_con);
		// Ŀ�ؼ��� ��ȯ
		return _con; 
	}

	// used�� �ִ� Ŀ�ؼ��� free�� �ݳ���
	// �ڿ��� �ݳ� ó��
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if (used.contains(_con)) { // Ŀ�ؼ��� used�� ���ԵǾ� �ִٸ�
			used.remove(_con); // used���� �� Ŀ�ؼ��� ������
			numCons--; // used�� ���� ���δ�
			flag = true;
		} else {
			throw new SQLException("ConnectionPool" + "�� ���� �ʳ׿�!!");
		}
		try {
			if (flag) {
				free.add(_con);
				numCons++; // free�� Ŀ�ؼ��� ��ȯ�ϰ� ���� �ø���
			} else {
				_con.close(); // Ŀ�ؼ��� �ݴ´�
			}
		} catch (SQLException e) {
			try {
				_con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	// ��� Connection �ڿ��� �ݳ���
	public void closeAll() { 
		// used�� �ִ� Ŀ�ؼ��� ��� ������ ����
		for (int i = 0; i < used.size(); i++) {
			Connection _con = (Connection) used.get(i);
			used.remove(i--);
			try {
				_con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// free�� �ִ� Ŀ�ؼ��� ��� ������ ����
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

	// ���� �ִ� Ŀ�ؼ��� ���� ��ȯ
	public int getMaxCons() {
		return maxCons;
	}

	// ���� �� Ŀ�ؼ� ��ȣ�� ��ȯ
	public int getNumCons() {
		return numCons;
	}
}
