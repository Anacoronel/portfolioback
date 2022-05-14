import { EducExpService } from './../../services/educ-exp.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Subscription } from 'rxjs';
import { Education } from 'src/app/models/Education';
import { Experience } from 'src/app/models/Experience';
import { ToastrService } from 'ngx-toastr';

import { Person } from 'src/app/models/Person';
import { TokenService } from 'src/app/services/security/token.service';

@Component({
  selector: 'app-educ-exp',
  templateUrl: './educ-exp.component.html',
  styleUrls: ['./educ-exp.component.css']
})
export class EducExpComponent implements OnInit {

  education: Education[] = [];

  experience: Experience[] = [];

  id: any;
  institution: string = '';
  date: string = '';
  link: string = '';
  title: string = '';
  company: string = '';
  position: string = '';
  endTime: string = '';
  startTime: string = '';
  modalRef?: BsModalRef;
  isLogged = false;
  subscription?: Subscription;
  form: FormGroup = new FormGroup({
    id: new FormControl(''),
    institution: new FormControl(''),
    date: new FormControl(''),
    link: new FormControl(''),
    title: new FormControl(''),
    startTime: new FormControl(''),
    endTime: new FormControl(''),
    company: new FormControl(''),
    position: new FormControl(''),
  });
  isAdmin: boolean=false;
  errMsj: string="";


  constructor(
    private educexpService: EducExpService,
    private FormBuilder: FormBuilder,
    private modalService: BsModalService,
    private tokenService: TokenService,
    private router: Router,
    private toastr: ToastrService

  ) { }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  openModal1(template1: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template1);
  }
  openModal2(templateed: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templateed);
  }
  penModaexp(templateexp: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templateexp);
  }

  ngOnInit(): void {
    this.educexpService.getEducation().subscribe((education) => {
      this.education = education;
    });

    this.educexpService.getExperience().subscribe((experience) => {
      this.experience = experience;
    });

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    this.isAdmin = this.tokenService.isAdmin();


  }

  deleteEdu(education: Education) {
    console.log(education.id);
    this.education = this.education.filter((e) => e !== education);
    this.educexpService.deleteEducation(education).subscribe((e) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    
    
    this.modalService.hide();
  }

  addEdu() {
    const { id, institution, date, link, title } = this;
    const newEdu = { id, institution, date, link, title};
    this.educexpService.addEducation(newEdu).subscribe((dato) => {
      this.education.push(dato);
    },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();


  }

  editEdu(education: Education) {
    this.id = education.id;
    this.institution = education.institution;
    this.date = education.date;
    this.title = education.title;
    this.link = education.link;
    this.educexpService.editEducation(education).subscribe((education) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();

  }

  editarExp(experience: Experience) {
    this.id = experience.id;
    this.company = experience.company;
    this.startTime = experience.startTime;
    this.endTime = experience.endTime;
    this.position = experience.position;
    this.link = experience.link;
    this.educexpService.editExperience(experience).subscribe((exp) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
    });
    this.modalService.hide();

  }

  deleteExp(experience: Experience) {
    this.experience = this.experience.filter((e) => e !== experience);
    this.educexpService.deleteExperience(experience).subscribe((exp) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    
    
    this.modalService.hide();
  }

  addExp() {
    const { id, company, startTime, endTime, link, position} = this;
    const newExp = { id, company, startTime, endTime, link, position};
    this.educexpService.addExperience(newExp).subscribe((dato) => {
      this.experience.push(dato);
    },
    err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
    });
    this.modalService.hide();
   
  }
}

