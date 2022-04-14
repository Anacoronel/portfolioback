import { ProjSkillService } from './../../services/proj-skill.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Person } from 'src/app/models/Person';
import { Project } from 'src/app/models/Project';
import { Skill } from 'src/app/models/Skill';
import { TokenService } from 'src/app/services/security/token.service';
import { NgCircleProgressModule } from 'ng-circle-progress';

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
  tecn: string = "";
  person!: Person;
  url: string = "";
  modalRef?: BsModalRef;
  isLogged = false;
  isAdmin = false;



  constructor(private projskillService: ProjSkillService, private modalService: BsModalService, private tokenService: TokenService
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
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    this.isAdmin = this.tokenService.isAdmin();

  }



  editProj(project: Project) {
    console.log('edit ' + project.id);

    this.id = project.id;
    this.date = project.date;
    this.link = project.link;
    this.text = project.text;
    this.tecn = project.tecn;
    this.person = project.person;

    this.projskillService.editProject(project).subscribe((project) => { });
    this.modalService.hide();

  }



  deleteProj(project: Project) {
    console.log(project.id);
    this.project = this.project.filter((e) => e !== project);
    this.projskillService.deleteProject(project).subscribe();
    this.modalService.hide();
  }

  addProj() {
    console.log('submitproy', this.project);
    const { id, date, link, text, tecn, person } = this;
    const newProj = { id, date, link, text, tecn, person };
    this.projskillService.addProject(newProj).subscribe((dato) => {
      this.project.push(dato);

    });
    this.modalService.hide();
  }
  editSk(skill: Skill) {
    console.log('edit ' + skill.id);
    this.id = skill.id;
    this.date = skill.text;
    this.value = skill.value;
    this.person = skill.person;
    this.projskillService.editSkill(skill).subscribe((Skill) => { });
    this.modalService.hide();

  }
  deleteSk(skill: Skill) {
    console.log(skill.id);
    this.skill = this.skill.filter((e) => e !== skill);
    this.projskillService.deleteSkills(skill).subscribe();
    this.modalService.hide();
  }
  addSk() {
    console.log('submitskill', this.skill);
    const { id, text, value, person } = this;
    const newSkill = { id, text, value, person };

    this.projskillService.addSkill(newSkill).subscribe((dato) => {
      console.log(dato);
      this.skill.push(dato);
    });
    this.modalService.hide();
  }

}


