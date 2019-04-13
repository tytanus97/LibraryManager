<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">

<head>

    <title>Register New User Form</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        .error {color:red}
        body {
            background-color: #05194C;
        }

        section {
            clear:both;
            float:left;
            width:80%;
            margin-left:25%;
            color:white;

        }

    </style>

</head>

<body>

<section>

    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-primary">

            <div class="panel-heading">
                <div class="panel-title">Register New User</div>
            </div>

            <div style="padding-top: 30px" class="panel-body">

                <!-- Registration Form -->
                <form:form action="${pageContext.request.contextPath}/registration/processRegistration"
                           modelAttribute="crmUser"
                           class="form-horizontal">

                    <!-- Place for messages: error, alert etc ... -->
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>

                                <!-- Check for registration error -->
                                <c:if test="${userExistsError != null}">

                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                            ${userExistsError}
                                    </div>

                                </c:if>
                                <c:if test="${emailExistsError != null}">

                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                            ${emailExistsError}
                                    </div>

                                </c:if>

                            </div>
                        </div>
                    </div>

                    <!-- User name -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:errors path="userName" cssClass="error" />
                        <form:input path="userName" placeholder="username (*)" class="form-control" />
                    </div>

                    <!-- Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <form:errors path="password" cssClass="error" />
                        <form:password path="password" placeholder="password (*)" class="form-control" />
                    </div>

                    <!-- Confirm Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <form:errors path="matchingPassword" cssClass="error" />
                        <form:password path="matchingPassword" placeholder="confirm password (*)" class="form-control" />
                    </div>

                    <!-- Email -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:errors path="email" cssClass="error" />
                        <form:input path="email" placeholder="email (*)" class="form-control" />
                    </div>



                    <!-- Register Button -->
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                    </div>

                </form:form>

            </div>

        </div>

    </div>

</section>

</body>
</html>