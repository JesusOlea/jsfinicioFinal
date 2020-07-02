package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.DisciplinaRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class DisciplinaController {
    private DisciplinaModel disciplinaModel;
    private DisciplinaRepository disciplinaRepository;
    private List<DisciplinaModel> listaDeDisciplinas;
    private ProfessorModel professorModel;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;
    private AlunoModel alunoModel;
    private AlunoRepository alunoRepository;
    private List<AlunoModel> listaDeAlunos;
    private AreaModel areaModel;
    private AreaRepository areaRepository;
    private List<AreaModel> listaDeAreas;
    
    
    
    public DisciplinaController(){
        this.disciplinaModel = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
        this.listaDeDisciplinas = new ArrayList<>();
        this.professorModel = new ProfessorModel();
        this.professorRepository = new ProfessorRepository();
        this.listaDeProfessores = new ArrayList<>();
        this.alunoModel = new AlunoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeAlunos = new ArrayList<>();
        this.areaModel = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.listaDeAreas = new ArrayList<>();
        
    }
    
    public String salvar(){
        this.professorModel = this.professorRepository.buscarPorId(this.professorModel.getIdpessoa());
        this.disciplinaModel.setProfessor(this.professorModel);
        this.areaModel = this.professorModel.getArea();
        this.disciplinaModel.setArea(this.areaModel);
        this.disciplinaRepository.salvar(disciplinaModel);
        this.disciplinaModel = new DisciplinaModel();
        return "buscarDisciplina.xhtml?faces-redirect=true";
    }
    
    public void buscar(){
        this.listaDeDisciplinas = this.disciplinaRepository.buscarTodos();
    }
    
    public String editarPorId(long iddisciplina) throws IOException {
        this.disciplinaModel = this.disciplinaRepository.buscarPorId(iddisciplina);
        return "editarDisciplina.xhtml?faces-redirect=true";
    }
    
    public void excluirPorId(long iddisciplina) {
        this.disciplinaRepository.excluirPorId(iddisciplina);
    }

    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public AreaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(AreaModel areaModel) {
        this.areaModel = areaModel;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<AreaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }
    
    

    
}