<% 
jp.sf.fess.crud.util.SAStrutsUtil.addSessionMessage(request, "error.login_error");
 %><c:redirect url="/login/login?msgs=error.login_error" />