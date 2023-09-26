<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/layout/header.jsp" />

<c:url var="getBoardList" value="/board/getBoardList">
    <c:param name="page" value="${pagination.page}"/>
    <c:param name="range" value="${pagination.range}"/>
</c:url>


<script>
    $(document).on('click', '#btnWriteForm', function(e) {
        console.log("클릭 이벤트 확인")
        e.preventDefault();
        location.href = "${pageContext.request.contextPath}/board/writeForm";
    });

    function fn_contentView(bid) {
        var url = "${pageContext.request.contextPath}/board/getBoardContent";
        url = url + "?bid=" + bid;
        window.location.href = url;
    }

    // 이전 버튼 이벤트
    function fn_prev(page, range, rangeSize) {
        var page = ((range - 2) * rangeSize) + 1;
        var range = range - 1;

        var url = "${pageContext.request.contextPath}/board/getBoardList";
        url = url + "?page=" + page;
        url = url + "&range=" + range;

        location.href = url;
    }

    // 페이지 번호 클릭
    function fn_pagination(page, range, rangeSize, searchType, keyword) {
        var url = "${pageContext.request.contextPath}/board/getBoardList";
        url = url + "?page=" + page;
        url = url + "&range=" + range;

        location.href = url;
    }

    // 다음 버튼 이벤트
    function fn_next(page, range, rangeSize) {
        var page = parseInt((range * rangeSize)) + 1;
        var range = parseInt(range) + 1;

        var url = "${pageContext.request.contextPath}/board/getBoardList";
        url = url + "?page=" + page;
        url = url + "&range=" + range;

        location.href = url;
    }

    $(document).on('click', '#btnSearch', function(e) {
    e.preventDefault();
        var url = "${pageContext.request.contextPath}/board/getBoardList";
        url = url + "?searchType=" + $('#searchType').val();
        url = url + "&keyword=" + $('#keyword').val();
        location.href = url;
        console.log(url);
    });
</script>

<body>
<div class="container mt-4">
    <h2 class="mb-4">Board List</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">NO</th>
                <th scope="col">글제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
                <th scope="col">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${empty boardList}">
                    <tr>
                        <td colspan="5" class="text-center">데이터가 없습니다.</td>
                    </tr>
                </c:when>
                <c:when test="${not empty boardList}">
                    <c:forEach var="list" items="${boardList}" varStatus="loop">
                        <tr>
                            <td><c:out value="${list.bid}" /></td>
                            <td>
                                <a href="#" onClick="fn_contentView(<c:out value="${list.bid}" />)">
                                    <c:out value="${list.title}" />
                                </a>
                            </td>
                            <td><c:out value="${list.reg_id}" /></td>
                            <td><c:out value="${list.reg_dt}" /></td>
                            <td><c:out value="${list.view_cnt}" /></td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
            </tbody>
        </table>
    </div>

    <div class="d-flex justify-content-end mt-3">
        <button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
    </div>

    <!-- pagination{s} -->
    <div id="paginationBox" class="mt-3 d-flex justify-content-center">
        <ul class="pagination">
            <c:if test="${pagination.prev}">
                <li class="page-item">
                    <a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a>
                </li>
            </c:if>
            <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
                <li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}" />">
                    <a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">${idx}</a>
                </li>
            </c:forEach>
            <c:if test="${pagination.next}">
                <li class="page-item">
                    <a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
                </li>
            </c:if>
        </ul>
    </div>
    <!-- pagination{e} -->

    <div class="row justify-content-center mt-3" style="margin-bottom: 100px;">
        <div class="col-md-4">
            <select class="form-select" name="searchType" id="searchType">
                <option value="title">제목</option>
                <option value="content">본문</option>
                <option value="reg_id">작성자</option>
            </select>
        </div>
        <div class="col-md-6">
            <div class="input-group">
                <input type="text" class="form-control" name="keyword" id="keyword" placeholder="검색어를 입력하세요">
                <button class="btn btn-primary" name="btnSearch" id="btnSearch">검색</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/view/layout/footer.jsp" />

</body>

</html>
