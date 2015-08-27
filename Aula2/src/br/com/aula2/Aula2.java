package br.com.aula2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Aula2
 */
@WebServlet({ "/TrataRequisicao", "/ola" })
public class Aula2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Aula2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter saida = response.getWriter();
		
		saida.print("Xablau!!!");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("saida.jsp");
		
		String usuario = request.getParameter("nmusuario");
		String senha = request.getParameter("nmsenha");
		
		HttpSession sessao = request.getSession();
		
		if(usuario.equals("João") && senha.equals("123")){
			sessao.setAttribute("attrMensagem", "Usuário logado com sucesso!");
		}else{
			sessao.setAttribute("attrMensagem", "Usuario ou senha incorreta!");			
		}
		
		rd.forward(request, response);
//		System.out.println("O usuário "+usuario);
//		System.out.println("com senha "+senha);
//		System.out.println("Acabou de se logar");

	}

}
