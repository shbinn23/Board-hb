<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/layout/header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Root URL Test</title>
</head>

<script>
    $(document).on('click', '#btnWriteForm', function(e) {
        console.log("클릭 이벤트 확인")
        e.preventDefault();
        location.href = "${pageContext.request.contextPath}/board/boardForm";
    });

    function fn_contentView(bid) {
        var url = "${pageContext.request.contextPath}/board/getBoardContent";
        url = url + "?bid=" + bid
        location.href = url;
    }

    var rootUrl = window.location.origin;
    console.log("Root URL: " + rootUrl);
</script>

<body>
<article>
    <div class="container">
        <div class="table-responsive">
            <div class="container">
                <h2>Board List</h2>
                <p>Context Path: ${pageContext.request.contextPath}</p>
                <table class="table table-striped table-sm">
                    <colgroup>
                        <col style="width: 5%;" />
                        <col style="width: auto;" />
                        <col style="width: 15%;" />
                        <col style="width: 10%;" />
                        <col style="width: 10%;" />
                    </colgroup>
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">NO</th>
                        <th scope="col">글제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${empty boardList}">
                            <tr>
                                <td colspan="5" align="center">데이터가 없습니다.</td>
                            </tr>
                        </c:when>
                        <c:when test="${not empty boardList}">
                            <c:forEach var="list" items="${boardList}" varStatus="loop">
                                <tr>
                                    <td><c:out value="${list.bid}"></c:out></td>
                                    <td>
                                        <a href="#" onClick="fn_contentView(<c:out value="${list.bid}"/>)">
                                            <c:out value="${list.title}" />
                                        </a>
                                    </td>
                                    <td><c:out value="${list.reg_id}" /></td>
                                    <td><c:out value="${list.view_cnt}" /></td>
                                    <td><c:out value="${list.reg_dt}" /></td>
                                </tr>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
        <div>
            <button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
        </div>
    </div>
</article>

</div>
</body>
</html>
