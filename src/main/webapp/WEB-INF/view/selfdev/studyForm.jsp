<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/layout/header.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Board List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <h2 class="mb-4">Board List</h2>

    <div class="row">
        <!-- 왼쪽: 지출 기록 폼 -->
        <div class="col-md-6">
            <div class="expense-form">
                <h3>지출 기록</h3>
                <form action="/myapp/expense/recordExpense" method="post">
                    <div class="form-group">
                        <label for="amount">금액:</label>
                        <input type="text" class="form-control" id="amount" name="amount" required>
                    </div>

                    <div class="form-group">
                        <label for="description">내용:</label>
                        <input type="text" class="form-control" id="description" name="description" required>
                    </div>

                    <div class="form-group">
                        <label for="category">카테고리:</label>
                        <input type="text" class="form-control" id="category" name="category" required>
                    </div>

                    <!-- 레코드 날짜 입력 -->
                    <!-- 추가 필드가 있다면 여기에 추가 -->

                    <button type="submit" class="btn btn-primary">기록</button>
                </form>

                <!-- 기록 성공 또는 에러 메시지 표시 -->
                <c:if test="${recordSuccess eq true}">
                    <p class="text-success">기록이 성공적으로 완료되었습니다.</p>
                </c:if>
                <c:if test="${recordError eq true}">
                    <p class="text-danger">기록 중 오류가 발생했습니다. 다시 시도해주세요.</p>
                </c:if>
            </div>
        </div>

        <!-- 오른쪽: 지출 History -->
        <div class="col-md-6">
            <div class="expense-history">
                <h3>지출 History</h3>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>날짜</th>
                            <th>금액</th>
                            <th>내용</th>
                            <th>카테고리</th>
                            <!-- 추가 필드에 대한 헤더를 여기에 추가 -->
                        </tr>
                        </thead>
                        <tbody>
                        <!-- 기록된 지출 내역 표시 -->
                        <c:forEach var="expense" items="${expenseList}">
                            <tr>
                                <td>${expense.recordDate}</td>
                                <td>${expense.amount}</td>
                                <td>${expense.description}</td>
                                <td>${expense.category}</td>
                                <!-- 추가 필드에 대한 표시를 여기에 추가 -->
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS 및 jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
