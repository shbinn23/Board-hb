<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/layout/header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>board</title>

    <c:url var="saveReplyURL" value="/restBoard/saveReply"></c:url>
    <c:url var="updateReplyURL" value="/restBoard/updateReply"></c:url>
    <c:url var="deleteReplyURL" value="/restBoard/deleteReply"></c:url>

<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--        }--%>

<%--        .container {--%>
<%--            background-color: #f8f9fa;--%>
<%--            padding: 20px;--%>
<%--            border-radius: 10px;--%>
<%--        }--%>

<%--        .board_title {--%>
<%--            font-size: 24px;--%>
<%--            font-weight: bold;--%>
<%--            margin-bottom: 10px;--%>
<%--        }--%>

<%--        .board_info_box {--%>
<%--            font-size: 14px;--%>
<%--            color: #6c757d;--%>
<%--        }--%>

<%--        .board_content {--%>
<%--            margin-top: 20px;--%>
<%--            font-size: 16px;--%>
<%--        }--%>

<%--        .board_tag {--%>
<%--            margin-top: 10px;--%>
<%--            font-size: 14px;--%>
<%--            color: #007bff;--%>
<%--        }--%>

<%--        .btn-group {--%>
<%--            margin-top: 20px;--%>
<%--        }--%>
<%--    </style>--%>

<script>

    // 목록으로 이동
    $(document).on('click', '#btnList', function(){
        location.href = "${pageContext.request.contextPath}/board/getBoardList";
    });

    // 수정 버튼 클릭 이벤트
    $(document).on('click', '#btnUpdate', function(){
        var url = "${pageContext.request.contextPath}/board/editForm";
        url = url + "?bid="+${boardContent.bid};
        url = url + "&mode=edit";
        location.href = url;
    });

    // 삭제 버튼 클릭 이벤트
    $(document).on('click', '#btnDelete', function(){
        var url = "${pageContext.request.contextPath}/board/deleteBoard";
        url = url + "?bid=" + ${boardContent.bid};
        location.href = url;
    });

    // 스크립트 리팩토링
    function showReplyList() {
        var url = "${pageContext.request.contextPath}/restBoard/getReplyList";
        var paramData = { "bid": "${boardContent.bid}" };

        $.ajax({
            type: 'POST',
            url: url,
            data: paramData,
            dataType: 'json',
            success: function (result) {
                var htmls = "";

                if (result.length < 1) {
                    htmls = "등록된 댓글이 없습니다.";
                } else {
                    $(result).each(function () {
                        htmls += '<div class="media text-muted pt-3" id="rid' + this.rid + '">';
                        htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
                        htmls += '<title>Placeholder</title>';
                        htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
                        htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
                        htmls += '</svg>';
                        htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
                        htmls += '<span class="d-block">';
                        htmls += '<strong class="text-gray-dark">' + this.reg_id + '</strong>';
                        htmls += '<span style="padding-left: 7px; font-size: 9pt">';
                        htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.rid + ', \'' + this.reg_id + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';
                        htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.rid + ')" >삭제</a>';
                        htmls += '</span>';
                        htmls += '</span>';
                        htmls += this.content;
                        htmls += '</p>';
                        htmls += '</div>';
                    }); // each end
                }

                $("#replyList").html(htmls);
            } // Ajax success end
        }); // Ajax end
    }

    // 컨트롤러의 메소드 호출
    function refreshReplyList() {
        showReplyList();
    }

    // 컨트롤러의 메소드 호출
    $(document).ready(function(){
        refreshReplyList();
    });

    $(document).on('click', '#btnReplySave', function(){
        var replyContent = $('#content').val();
        var replyReg_id = $('#reg_id').val();
        var paramData = JSON.stringify({"content": replyContent, "reg_id": replyReg_id, "bid":'${boardContent.bid}'});
        var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};

        $.ajax({
            url: "${saveReplyURL}",
            headers: headers,
            data: paramData,
            type: 'POST',
            dataType: 'text',
            success: function(result){
                showReplyList();
                $('#content').val('');
                $('#reg_id').val('');
            },
            error: function(error){
                console.log("에러 : " + error);
            }
        });
    });

    function fn_editReply(rid, reg_id, content) {
        var htmls = "";

        htmls += '<div class="media text-muted pt-3" id="rid' + rid + '">';
        htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
        htmls += '<title>Placeholder</title>';
        htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
        htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
        htmls += '</svg>';
        htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
        htmls += '<span class="d-block">';
        htmls += '<strong class="text-gray-dark">' + reg_id + '</strong>';
        htmls += '<span style="padding-left: 7px; font-size: 9pt">';
        htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + rid + ', \'' + reg_id + '\')" style="padding-right:5px">저장</a>';
        htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';
        htmls += '</span>';
        htmls += '</span>';
        htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">' + content + '</textarea>';
        htmls += '</p>';
        htmls += '</div>';

        $('#rid' + rid).replaceWith(htmls);
        $('#rid' + rid + ' #editContent').focus();
    }

    function fn_updateReply(rid, reg_id) {
        var replyEditContent = $('#editContent').val();

        var paramData = JSON.stringify({
            "content": replyEditContent,
            "rid": rid
        });

        var headers = {
            "Content-Type": "application/json",
            "X-HTTP-Method-Override": "POST"
        };

        $.ajax({
            url: "${updateReplyURL}",
            headers: headers,
            data: paramData,
            type: 'POST',
            dataType: 'text',
            success: function (result) {
                console.log(result);
                showReplyList();
            },
            error: function (error) {
                console.log("에러 : " + error);
            }
        });
    }

    function fn_deleteReply(rid) {
        var paramData = { "rid": rid };

        $.ajax({
            url: "${deleteReplyURL}",
            data: paramData,
            type: 'POST',
            dataType: 'text',
            success: function (result) {
                showReplyList();
            },
            error: function (error) {
                console.log("에러 : " + error);
            }
        });
    }

</script>
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">자유게시판</h2>
    <div class="bg-white rounded shadow p-4">
        <h3 class="board_title"><c:out value="${boardContent.title}" /></h3>
        <div class="board_info_box">
            <span class="board_author"><c:out value="${boardContent.reg_id}" /></span>,
            <span class="board_date"><c:out value="${boardContent.reg_dt}" /></span>
        </div>
        <div class="board_content">${boardContent.content}</div>
        <div class="board_tag">TAG: <c:out value="${boardContent.tag}" /></div>
        <div class="btn-group">
            <button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
            <button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
            <button type="button" class="btn btn-secondary" id="btnList">목록</button>
        </div>
    </div>

    <div class="my-4 p-4 bg-white rounded shadow">
        <h4 class="border-bottom pb-2 mb-4">Reply List</h4>
        <div id="replyList" style="margin-bottom: 20px;"></div>

        <!-- Reply Form -->
        <form:form name="form" id="form" role="form" modelAttribute="replyVO" method="post">
            <form:hidden path="bid" id="bid" />
            <div class="row">
                <div class="col-md-10">
                    <form:textarea path="content" id="content" class="form-control" rows="3"
                                   placeholder="댓글을 입력해 주세요"></form:textarea>
                </div>
                <div class="col-md-2">
                    <form:input path="reg_id" class="form-control mb-3" id="reg_id" placeholder="댓글 작성자"></form:input>
                    <button type="button" class="btn btn-primary" id="btnReplySave" style="width: 100%;">저장</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
