package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.LoginController;
import br.edu.ifsp.pep.entity.NivelAcesso;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class LifeCycleListener implements PhaseListener {

    @Inject
    private LoginController loginController;

    @Override
    public void afterPhase(PhaseEvent event) {

        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        
        if(loginController.getPessoaAutenticada() == null){
            ctx.getExternalContext().getFlash().setKeepMessages(true);
            
            switch(pagina){
                case "/financeiro/List.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/financeiro/Create.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/pessoa/ListPessoa.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/veiculo/CreateVeiculo.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/veiculo/ListVeiculo.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/veiculo/UpdateVeiculo.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/comum.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
            }
            
        } else if(loginController.getPessoaAutenticada().getNivelAcesso() == NivelAcesso.Comum){
            ctx.getExternalContext().getFlash().setKeepMessages(true);
            Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
            
            switch(pagina){
                case "/financeiro/List.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/financeiro/Create.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
            }
        } else if(loginController.getPessoaAutenticada().getNivelAcesso() == NivelAcesso.Financeiro){
            ctx.getExternalContext().getFlash().setKeepMessages(true);
            Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
            
            switch(pagina){
                case "/pessoa/ListPessoa.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/veiculo/CreateVeiculo.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/veiculo/ListVeiculo.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/veiculo/UpdateVeiculo.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
                case "/comum.xhtml":
                    Mensagem.erro("Não possui nivel Acesso para acessar!!!!");
                    redirecionar(ctx, "/index.xhtml");
                    break;
            }
        }
        
//        if (pagina.equals("/financeiro/List.xhtml")){
//            if (loginController.getPessoaAutenticada() == null || 
//                loginController.getPessoaAutenticada().getNivelAcesso() == NivelAcesso.Comum){
//                redirecionar(ctx, "/index.xhtml");
//            }
//        } else if (pagina.equals("/financeiro/Create.xhtml")) {
//            if (loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Administrador){
//                redirecionar(ctx, "/index.xhtml");
//            }
//        } else if (pagina.equals("/comum.xhtml")){
//            if (loginController.getPessoaAutenticada() == null ||
//                loginController.getPessoaAutenticada().getNivelAcesso() == NivelAcesso.Financeiro){
//                redirecionar(ctx, "/index.xhtml");
//            }
//        } else if (pagina.equals("/pessoa/Cadastro.xhtml")) {
//            if (loginController.getPessoaAutenticada() == null) {
//                //Redirecionar para página de erro ou login.
//                redirecionar(ctx, "/index.xhtml");
//            }
//        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            //Nome do projeto
            String projeto = ctx.getExternalContext()
                    .getRequestContextPath();

            //Encaminhar/Redirecionar
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
