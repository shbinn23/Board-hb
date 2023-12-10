<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/layout/header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>책 추천</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        h2 {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            margin: 0;
        }

        /* 왼쪽 폼 스타일 */
        form {
            margin: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            margin-bottom: 10px;
            padding: 5px;
        }

        /* 오른쪽 테이블 스타일 */
        table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>

<body>
<div class="container mt-4">
    <h2 class="mb-4">책 추천</h2>

    <div class="row">
        <!-- 왼쪽: 책 추천 폼 -->
        <div class="col-md-6">
            <div class="book-form">
                <h3>책 추천</h3>
                <form action="/myapp/book/recordBook" method="post">
                    <div class="form-group">
                        <label for="bookTitle">도서 제목:</label>
                        <input type="text" class="form-control" id="bookTitle" name="title" required>
                    </div>

                    <div class="form-group">
                        <label for="author">저자:</label>
                        <input type="text" class="form-control" id="author" name="author" required>
                    </div>

                    <div class="form-group">
                        <label for="description">소개:</label>
                        <input type="text" class="form-control" id="description" name="description" required>
                    </div>

                    <button type="submit" class="btn btn-primary">추천</button>
                </form>

                <!-- 추천 성공 또는 에러 메시지 표시 -->
                <c:if test="${recordSuccess eq true}">
                    <p style="color: green;">추천이 성공적으로 완료되었습니다.</p>
                </c:if>
                <c:if test="${recordError eq true}">
                    <p style="color: red;">추천 중 오류가 발생했습니다. 다시 시도해주세요.</p>
                </c:if>
            </div>
        </div>

        <!-- 오른쪽: 책 추천 History -->
        <div class="col-md-6">
            <div class="book-history">
                <h3>책 추천 History</h3>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>도서 제목</th>
                            <th>저자</th>
                            <th>소개</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- 추천된 책 내역 표시 -->
                        <c:forEach var="book" items="${bookList}">
                            <tr>
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.description}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div
