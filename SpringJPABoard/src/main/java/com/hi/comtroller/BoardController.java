package com.hi.comtroller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hi.dto.BoardDTO;
import com.hi.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Transactional // 필요 시 클래스 전체에 기본값 설정
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 1. 게시판 입력창화면 요청 (읽기 전용)
    @GetMapping(value = "/board/insertForm")
    @Transactional(readOnly = true)
    public String boardInsertForm(BoardDTO boardDTO, Model model) {
        model.addAttribute("boardDTO", boardDTO);
        return "board/insertForm";
    }

    // 2. 게시판 입력 내용 저장 요청 
    @PostMapping(value = "/board/insert")
    public String boardInsert(BoardDTO boardDTO, RedirectAttributes rttr) throws Exception {
        log.info("board/insert" + boardDTO.toString());
        boolean result = boardService.insert(boardDTO);

        if (result == false) {
            rttr.addFlashAttribute("msg", "게시글 입력이 실패되었습니다.");
        } else {
        	rttr.addFlashAttribute("msg", "게시글 입력이 성공되었습니다.");
        	rttr.addAttribute("writer", boardDTO.getWriter());
        }
            return "redirect:/board/list";
      
    }

    // 3. 게시판 리스트 요청 (읽기 전용)
    @GetMapping(value = "/board/list")
    @Transactional(readOnly = true)
    public String boardList(Model model) throws Exception {
        List<BoardDTO> list = boardService.list();
        if (list == null || list.isEmpty()) {
            return "board/fail";
        }
        model.addAttribute("list", list);
        return "board/list";
    }

    // 4. 게시글 요청 (읽기 전용)
    @GetMapping(value = "/board/select")
    @Transactional(readOnly = true)
    public String boardselect(BoardDTO boardDTO, Model model) throws Exception {
        if (boardDTO.getBoardNo() <= 0) return "board/fail";
//        
//        BoardDTO result = boardService.select(boardDTO);
//        if (result == null) return "board/fail";

        model.addAttribute("boardDTO", null);
        return "board/select";
    }

    // 5. 게시글 삭제 요청
    @GetMapping(value = "/board/delete")
    @ResponseBody 
    public String boarddelete(BoardDTO boardDTO) throws Exception { 
        if (boardDTO.getBoardNo() <= 0) return "board/fail";
        
        boolean result = boardService.delete(boardDTO);
        return result ? "success" : "fail";
    }

    // 6. 게시판 수정폼 화면 요청 (읽기 전용)
    @GetMapping(value = "/board/updateForm")
    @Transactional(readOnly = true)
    public String boardUpdateForm(BoardDTO boardDTO, Model model) throws Exception {
        if (boardDTO.getBoardNo() <= 0) return "board/fail";
//        
//        BoardDTO result = boardService.select(boardDTO);
        model.addAttribute("boardDTO", null);
        return "board/updateForm";
    }
    
    // 7. 게시판 내용 수정 요청 
    @PostMapping(value = "/board/updateForm")
    public String boardUpdate(BoardDTO boardDTO) throws Exception {
        if (boardDTO.getBoardNo() <= 0) return "board/fail";
        
        boolean result = boardService.update(boardDTO);
        return result ? "board/success" : "board/fail";
    }
}