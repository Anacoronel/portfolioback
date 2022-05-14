import { ProjSkillService } from './../../services/proj-skill.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Person } from 'src/app/models/Person';
import { Project } from 'src/app/models/Project';
import { Skill } from 'src/app/models/Skill';
import { TokenService } from 'src/app/services/security/token.service';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-proj-skill',
  templateUrl: './proj-skill.component.html',
  styleUrls: ['./proj-skill.component.css']
})
export class ProjSkillComponent implements OnInit {

  project: Project[] = [];

  skill: Skill[] = [];
  id!: number;
  projects: any;
  value: any;
  link: string = "";
  date: string = "";
  text: string = "";
  techs: string = "";
  url: string = "";
  modalRef?: BsModalRef;
  errMsj: string="";




  constructor(private projskillService: ProjSkillService, private modalService: BsModalService, private tokenService: TokenService,     private toastr: ToastrService

  ) { }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  openModal1(template1: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template1);
  }
  openModal2(template2: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template2);
  }
  openModalsk(templatesk: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templatesk);
  }

  openModalsked(templatesked: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templatesked);
  }
  openModalskdel(templateskdel: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templateskdel);
  }
  ngOnInit(): void {
    this.projskillService.getProject().subscribe(project => {
      console.log(project);
      this.project = project;
    });

    this.projskillService.getSkills().subscribe(skill => {
      console.log(skill);
      this.skill = skill;
    });
    
  }



  editProj(project: Project) {

    this.id = project.id;
    this.date = project.date;
    this.link = project.link;
    this.text = project.text;
    this.techs = project.techs;

    this.projskillService.editProject(project).subscribe((project) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();

  }



  deleteProj(project: Project) {
    console.log(project.id);
    this.project = this.project.filter((e) => e !== project);
    this.projskillService.deleteProject(project).subscribe((dato) => {},err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();
  }

  addProj() {
    const { id, date, link, text, techs } = this;
    const newProj = { id, date, link, text, techs };
    this.projskillService.addProject(newProj).subscribe((dato) => {
      this.project.push(dato);

    },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();
  }
  editSk(skill: Skill) {
    this.id = skill.id;
    this.date = skill.text;
    this.value = skill.value;
    this.projskillService.editSkill(skill).subscribe((Skill) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();

  }
  deleteSk(skill: Skill) {
    console.log(skill.id);
    this.skill = this.skill.filter((e) => e !== skill);
    this.projskillService.deleteSkills(skill).subscribe((dato)=>{},err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();
  }
  addSk() {
    const { id, text, value } = this;
    const newSkill = { id, text, value };

    this.projskillService.addSkill(newSkill).subscribe((dato) => {
      this.skill.push(dato);
    },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();
  }
  isLogged(){
    return this.tokenService.isLogged();
  }
}


