<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
    request.setAttribute("userId",Integer.parseInt(request.getParameter("kasutajaId")));
    request.setAttribute("lauaNumber",Integer.parseInt(request.getParameter("lauaNumber")));
    request.setAttribute("pubiId",Integer.parseInt(request.getParameter("pubiId")));
    String strViewPage="/broneeri";
    RequestDispatcher dispatcher = request.getRequestDispatcher(strViewPage);
    if (dispatcher != null){
        dispatcher.forward(request, response);
    }
    else{
    }
%>