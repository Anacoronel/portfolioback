import { EducExpService } from './../../services/educ-exp.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Subscription } from 'rxjs';
import { Education } from 'src/app/models/Education';
import { Experience } from 'src/app/models/Experience';
<<<<<<< HEAD
import { ToastrService } from 'ngx-toastr';

=======
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
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
<<<<<<< HEAD
=======
  person!: Person;
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
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
<<<<<<< HEAD
  });
  isAdmin: boolean=false;
  errMsj: string="";

=======
    person: new FormControl(''),
  });
  isAdmin: boolean=false;
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6

  constructor(
    private educexpService: EducExpService,
    private FormBuilder: FormBuilder,
    private modalService: BsModalService,
    private tokenService: TokenService,
<<<<<<< HEAD
    private router: Router,
    private toastr: ToastrService

=======
    private router: Router
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
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
<<<<<<< HEAD
=======
      console.log(education);
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
      this.education = education;
    });

    this.educexpService.getExperience().subscribe((experience) => {
<<<<<<< HEAD
=======
      console.log(experience);
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
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
<<<<<<< HEAD
    this.educexpService.deleteEducation(education).subscribe((e) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    
    
=======
    this.educexpService.deleteEducation(education).subscribe();
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.modalService.hide();
  }

  addEdu() {
<<<<<<< HEAD
    const { id, institution, date, link, title } = this;
    const newEdu = { id, institution, date, link, title};
    this.educexpService.addEducation(newEdu).subscribe((dato) => {
      this.education.push(dato);
    },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
=======
    console.log('submitedu', this.education);
    const { id, institution, date, link, title, person } = this;
    const newEdu = { id, institution, date, link, title, person};
    this.educexpService.addEducation(newEdu).subscribe((dato) => {
      console.log(dato);
      this.education.push(dato);
    });
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.modalService.hide();


  }

  editEdu(education: Education) {
<<<<<<< HEAD
=======
    console.log('edit ' + education.id);
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.id = education.id;
    this.institution = education.institution;
    this.date = education.date;
    this.title = education.title;
    this.link = education.link;
<<<<<<< HEAD
    this.educexpService.editEducation(education).subscribe((education) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
=======
    this.person = education.person;
    this.educexpService.editEducation(education).subscribe((education) => { });
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.modalService.hide();

  }

  editarExp(experience: Experience) {
<<<<<<< HEAD
=======
    console.log('edit ' + experience.id);
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.id = experience.id;
    this.company = experience.company;
    this.startTime = experience.startTime;
    this.endTime = experience.endTime;
    this.position = experience.position;
    this.link = experience.link;
<<<<<<< HEAD
    this.educexpService.editExperience(experience).subscribe((exp) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
    });
=======
    this.person = experience.person;
    this.educexpService.editExperience(experience).subscribe((exp) => { });
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.modalService.hide();

  }

  deleteExp(experience: Experience) {
<<<<<<< HEAD
    this.experience = this.experience.filter((e) => e !== experience);
    this.educexpService.deleteExperience(experience).subscribe((exp) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    
    
=======
    console.log(experience.id);
    this.experience = this.experience.filter((e) => e !== experience);
    this.educexpService.deleteExperience(experience).subscribe();
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
    this.modalService.hide();
  }

  addExp() {
<<<<<<< HEAD
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
   
=======
    console.log('submitexp', this.experience);
    const { id, company, startTime, endTime, link, position, person } = this;
    const newExp = { id, company, startTime, endTime, link, position, person};
    this.educexpService.addExperience(newExp).subscribe((dato) => {
      console.log(dato);
      this.experience.push(dato);
    });
    this.modalService.hide();
>>>>>>> b9d5a89cdcf1b4a835e497efd4889669df7469d6
  }
}

