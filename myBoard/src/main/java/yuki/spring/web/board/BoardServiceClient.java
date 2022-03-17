package yuki.spring.web.board;

import java.util.List;
import org.springframework.context.support.*;

public class BoardServiceClient {
   
   public static void main(String[] args) {
      //1. ������ �����̳� ����
      AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
      //2. ������ �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup
      BoardService boardService = (BoardService) container.getBean("boardService");
      //3. �� ��� ��� �׽�Ʈ
      BoardVO vo = new BoardVO();
      vo.setTitle("�������߰�");
      vo.setWriter("��Ű");
      vo.setContent("��Ű��Ű!");
      boardService.insertBoard(vo);
      //4. �� �˻� ��� �׽�Ʈ
      List<BoardVO> boardList = boardService.getBoardList(vo);
      for(BoardVO board:boardList) {
         System.out.println("------>" + board.toString());
      }
      //5. ������ �����̳� ����
      container.close();
   }

}