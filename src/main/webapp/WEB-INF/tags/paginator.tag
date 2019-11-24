<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="count" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="step" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="urlprefix" required="true" rtexprvalue="true" type="java.lang.String" %>
<%
    out.println("Page: ");
    for (int i = 0; i <= (count - 1) / step; i++) {
        out.println(String.format("&nbsp<a href='%s%d'>%d</a>", urlprefix, i * step, i+1));
    }
%>
