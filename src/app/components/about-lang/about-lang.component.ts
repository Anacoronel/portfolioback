import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
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
  person:Person[]=[];
  person_id!:{Person:{id:any}};


  id: any;
  level: string = "";
  text: string = "";
  languages: string = "";
  modalRef?: BsModalRef;
  



  constructor(
    private aboutlangService: AboutLangService,
    private tokenService: TokenService,
    private modalService: BsModalService,
    private personService: PersonService

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
      console.log(data);
      this.about = data ;
    });

    this.aboutlangService.getLanguage().subscribe((data) => {
      console.log(data);

      this.language = data;
    });
    this.personService.getPerson().subscribe((data) => {
      console.log(data);

      this.person = data;
    });              
    
    
    


  }
  editAbt(about: About) {
    console.log('edit ' + about.id);
    this.id = about.id;
    this.text = about.text;
    this.person= about.person;
    this.aboutlangService.editAbout(about).subscribe((about) => { });
    this.modalService.hide();

  }

  deleteLang(language: Language) {
    console.log(language.id);
    this.aboutlangService.deleteLanguage(language).subscribe(() => {
      this.language = this.language.filter((e) => e !== language)
    });
    this.modalService.hide();
  }

  addLang() {

    const { id, languages, level,person}= this;
    const newIdioma = { id, languages, level,  person};
    this.aboutlangService.addLanguage(newIdioma).subscribe((dato) => {
      console.log(dato);
      this.language.push(dato);
    });
    this.modalService.hide();

  }

  editLang(language: Language) {
    console.log('edit ' + language.id);
    this.id = language.id;
    this.languages= language.languages;
    this.level = language.level;
    this.person = language.person;
    this.aboutlangService.editLanguage(language).subscribe((language) => { });
    this.modalService.hide();

  }
  isLogged(){
    return this.tokenService.isLogged() && this.tokenService.isAdmin();
  }

}



