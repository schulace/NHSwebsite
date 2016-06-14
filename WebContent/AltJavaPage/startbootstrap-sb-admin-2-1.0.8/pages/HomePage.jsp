<%@page import="project.serverLogic.userFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>

  <body>

    <div id="wrapper">

      <!-- Navigation -->
      <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
        </div>
        <!-- /.navbar-header -->
      </nav>

      <!-- Page Content -->
      <div id="page-wrapper">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-12">
              <h1 class="page-header">Blank</h1>
              <div class="panel-body">
                <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover">
                  	<% userFactory.deserializeStudentList(false);
                  	userFactory.deserializeTutorList(false);
                  	userFactory.deserializeTeacherList(false);
                  	String email = "";
            		Cookie[] cookies = request.getCookies();
            		if(cookies != null)
            		{
            			for (Cookie cookie : cookies)
            			{
                            if (cookie.getName().equals("NHSLoginEmail"))
                            {
                            	email = cookie.getValue();
                            }
                        }
                    }
            		String userSchedTable = "no schedule data";
            		boolean isStudent = true;
            		try
            		{
            			userSchedTable = userFactory.getStudentByName(email).getCalendar().getStudentSchedule().toPrettierHTML();
            		}
            		catch(Exception e)
            		{
            			try
            			{
            				userSchedTable = userFactory.getTutorByName(email).getCalendar().getStudentSchedule().toPrettierHTML();
            			}
            			catch(Exception e1)
            			{
            				userSchedTable = userFactory.getTeacherByName(email).getCalendar().getStudentSchedule().toPrettierHTML();
            			}
            			isStudent = false;
            		}
            		
            		userFactory.serializeStudentList();
            		userFactory.serializeTutorList();
            		userFactory.serializeTeacherList();

                  	%>
                    <%= userSchedTable %>
                    
                    
                  </table>
                </div>
                <%
                String reqButtonHref = "";
                String reqButtonText = "";
                if(isStudent)
                {
                	reqButtonHref = "HelpRequest.jsp";
                	reqButtonText = "Request Help!";
                }
                else
                {
                	reqButtonHref = "viewHelpRequests.jsp";
                	reqButtonText = "see available requests for help";
                }
                %>
                <a href=<%=reqButtonHref %>><button type="button" class="btn btn-primary btn-lg btn-block"><%=reqButtonText%></button></a>
                <br>
                <form action="../../../userInfoEntry.jsp" method="post">
                 <input type="submit" class="btn btn-primary btn-lg btn-block" value="re-enter schedule">
                 </form>
                <br>
                <div class="row">
                  <div class="col-lg-6">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        Study Guides
                      </div>
                      <!-- /.panel-heading -->
                      <div class="panel-body">
                        <p>Enter Study Guides here:<br><br>
                        Quod placeat eos occaecati velit dolores. Aut harum ea tenetur repellat cum corrupti maiores. Provident temporibus et dolor deleniti. Qui et consequatur sapiente eum hic quaerat et. Quam qui omnis error nam rem laboriosam laudantium.
                        Vero voluptas assumenda et autem minima. Dolor repellat est et laboriosam suscipit architecto dolorum quia. Est officiis autem dicta ipsam adipisci veritatis.
                        Eveniet et fuga labore autem eum eligendi occaecati. Voluptatum qui dicta autem ab error. Fugit tempore ea nam exercitationem eius et aperiam perferendis. In ducimus quo nesciunt et enim. Minus ipsa quia voluptas dignissimos sint quaerat libero. Veniam harum temporibus qui veritatis ad.
                        A quisquam neque ullam vel sed est. Occaecati ad dolorem praesentium facilis rerum magnam occaecati. Labore dicta esse accusantium.
                        Blanditiis est nihil eum. Pariatur saepe aut ea impedit aut voluptas et. Officiis dolorem voluptatem in inventore voluptate laboriosam voluptas.
                        <!-- /.table-responsive -->
                      </div>
                      <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                  </div>
                  <!-- /.col-lg-6 -->
                  <div class="col-lg-6">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        Scheduled Tuitoring sessions
                      </div>
                      <!-- /.panel-heading -->
                      <div class="panel-body">
                        <div class="table-responsive">
                          <table class="table">
                            <thead>
                              <tr>
                                <th>Date</th>
                                <th>Tuitor</th>
                                <th>Location</th>
                                <th>Block</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td>1/1/16</td>
                                <td>Mark</td>
                                <td>Media Center</td>
                                <td>4</td>
                              </tr>
                              <tr>
                                <td>2/1/16</td>
                                <td>Jacob</td>
                                <td>Learning Center Rm 201</td>
                                <td>8</td>
                              </tr>
                              <tr>
                                <td>3/1/16</td>
                                <td>Larry</td>
                                <td>Study Hall</td>
                                <td>2</td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                        <!-- /.table-responsive -->
                      </div>
                      <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                  </div>
                  <!-- /.col-lg-6 -->
                </div>
              </div>

            </div>
            <!-- /.col-lg-12 -->
          </div>
          <!-- /.row -->

        </div>
        <!-- /.container-fluid -->
      </div>
      <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

  </body>

</html>
