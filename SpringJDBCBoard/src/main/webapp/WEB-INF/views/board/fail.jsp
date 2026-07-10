<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 등록 실패</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <div class="error-container">
        <div class="error-box">
            <div class="error-title-wrapper">
                <svg class="icon-warning" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <path d="M10.29 3.86L1.82 18a2 2 0 0 0 1.71 3h16.94a2 2 0 0 0 1.71-3L13.71 3.86a2 2 0 0 0-3.42 0z"></path>
                    <line x1="12" y1="9" x2="12" y2="13"></line>
                    <line x1="12" y1="17" x2="12.01" y2="17"></line>
                </svg>
                <h2 class="error-title">게시글 등록에 실패하였습니다.</h2>
            </div>
            <p class="error-desc">입력하신 내용을 다시 확인하거나 잠시 후 다시 시도해 주세요.</p>
        </div>

        <div class="button-group">
            <button type="button" class="btn btn-retry" onclick="handleRetry()">
                <svg class="icon-btn" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path>
                    <path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path>
                </svg>
                다시 작성하기
            </button>
            <button type="button" class="btn btn-list" onclick="goToList()">
                <svg class="icon-btn" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z"></path>
                </svg>
                목록으로 돌아가기
            </button>
        </div>
    </div>

    <script src="script.js"></script>
</body>
</html>