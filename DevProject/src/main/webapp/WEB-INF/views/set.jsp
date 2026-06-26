<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <title>ì´ë²¤í¸ì²ë¦¬ë°©ì</title>
  <link rel="stylesheet" href="linkToCSS" />
</head>
<style>
  * {
    margin: 0 auto;
    padding: 0 auto;
    box-sizing: border-box;
  }

  .container {
    border: 1px solid black;
    width: 80%;
    margin: 0 auto;
    padding: 10px 10px;
  }

  section {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
    border: 1px solid black;

  }

  ul {
    list-style-type: none;
    border: 1px solid blue;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  ul>li {
    border: 1px solid brown;
    margin: 20px;
    gap: 20px;
    padding: 10px;
  }

  section>img {
    border: 1px solid black;
    padding: 10px 10pz;
  }
</style>

<body>
  <div class="container">
    <section>
      <img src="./images/flower.jpg" alt="ê½" id="img1">
    </section>
    <ul>
      <li id="btn1">ë°ì¤1</li>
      <li id="btn2">ë°ì¤2</li>
      <li id="btn3">ë°ì¤3</li>
    </ul>
  </div>

  <script>
    //1. ììë¥¼ ì°¾ëë¤.(ì´ë¯¸ì§,ë¦¬ì¤í¸ë²í¼1,2,3)
    // ìëµ ë¶ê°
    let img1 = document.querySelector('#img1')
    let btn1 = document.querySelector('#btn1')
    let btn2 = document.querySelector('#btn2')
    let btn3 = document.querySelector('#btn3')
    //2. ì´ë²¤í¸ ì¤ì 
    //ìëµë¶ê°
    // btn1.onclick = changeImg1;
    // btn2.onclick = changeImg2;
    // btn3.onclick = changeImg3;
    btn1.onmouseover = () => changeImg(1);
    btn2.ondblclick = () => changeImg(2);
    btn3.onclick = () => changeImg(3);

    //3.í¨ì ì ì¸ìì¼ë¡ ì´ë²¤í¸ë¥¼ ì¤ë¤
    function changeImg(select = 1) {
      switch (select) {
        case 1:
          img1.src = "./images/flower1.jpg";
          break;
        case 2:
          img1.src = "./images/prod1.jpg";
          break;
        case 3:
          img1.src = "./images/prod2.jpg";
          break;

        default:
          img1.src = "./images/flower1.jpg";
          break;
      }
    }

    //   img1.src = "./images/flower1.jpg";
    // }
    // function changeImg2(params) {
    //   img1.src = "./images/prod1.jpg";
    // }
    // function changeImg3(params) {
    //   img1.src = "./images/prod2.jpg";
    // }
  </script>
</body>

</html>