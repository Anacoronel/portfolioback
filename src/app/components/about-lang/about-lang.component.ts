import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ToastrService } from 'ngx-toastr';
import { About } from 'src/app/models/About';
import { Language } from 'src/app/models/Language';
import { Person } from 'src/app/models/Person';
import { AboutLangService } from 'src/app/services/about-lang.service';
import { PersonService } from 'src/app/services/person.service';
import { TokenService } from 'src/app/services/security/token.service';

@Component({
  selector: 'app-about-lang',
  templateUrl: './about-lang.component.html',
  styleUrls: ['./about-lang.component.css']
})
export class AboutLangComponent implements OnInit {
  language: Language[]=[];
  about: About[] = [];


  id: any;
  level: string = "";
  text: string = "";
  languages: string = "";
  modalRef?: BsModalRef;
  isLogged : boolean=false;
  isAdmin: boolean=false;
  errMsj: string="";



  



  constructor(
    private aboutlangService: AboutLangService,
    private tokenService: TokenService,
    private modalService: BsModalService,
    private personService: PersonService,
    private toastr: ToastrService


  ) {}

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  openModalid(templateid: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templateid);

  }
  openModaledid(templateedid: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templateedid);

  }
  openModaldelid(templatedelete: TemplateRef<any>) {
    this.modalRef = this.modalService.show(templatedelete);
  }

  ngOnInit(): void {
    this.aboutlangService.getAbout().subscribe((data) => {
      this.about = data ;
    });

    this.aboutlangService.getLanguage().subscribe((data) => {

      this.language = data;
    });
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    this.isAdmin = this.tokenService.isAdmin();


  

    
    
    


  }
  editAbt(about: About) {
    this.id = about.id;
    this.text = about.text;
    this.aboutlangService.editAbout(about).subscribe((about) => { }, err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();

  }

  deleteLang(language: Language) {
    this.aboutlangService.deleteLanguage(language).subscribe(() => {
      this.language = this.language.filter((e) => e !== language)
    },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();
  }

  addLang() {

    const { id, languages, level}= this;
    const newIdioma = { id, languages, level};
    this.aboutlangService.addLanguage(newIdioma).subscribe((dato) => {
      this.language.push(dato);
    },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();

  }

  editLang(language: Language) {
    this.id = language.id;
    this.languages= language.languages;
    this.level = language.level;
    this.aboutlangService.editLanguage(language).subscribe((language) => { },err => {
      this.errMsj = err.error.message;
      this.toastr.error(this.errMsj, 'Admin privileges not found', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });});
    this.modalService.hide();

  }
  

}



