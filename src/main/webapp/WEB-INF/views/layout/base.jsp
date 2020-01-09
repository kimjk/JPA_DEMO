<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta name="viewport"
          content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
    <meta name="format-detection" content="telephone=no">
    <meta charset="utf-8">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>demo</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css?v=2"/>
    <script type=text/javascript src="${pageContext.request.contextPath}/static/common/js/manifest.js?v=2"></script>
    <script type=text/javascript src="${pageContext.request.contextPath}/static/common/js/vendor.js?v=2"></script>
    <script type=text/javascript src="${pageContext.request.contextPath}/static/common/js/app.js?v=2"></script>
    <script>
        var CTX_PATH = '${pageContext.request.contextPath}';
        Vue.prototype.axios.defaults.baseURL = CTX_PATH;
    </script>
    <style type="text/css">
        [v-cloak] > * {
            display: none;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <tiles:insertAttribute name="header"/> <!--  /WEB-INF/views/common/layout/header.jsp -->
        <tiles:insertAttribute name="body"/> <!-- body -->
        <%--<tiles:insertAttribute name="footer"/> <!-- /WEB-INF/views/common/layout/footer.jsp -->--%>
    </div>
</body>
</html>