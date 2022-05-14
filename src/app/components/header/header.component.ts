import { Component, OnInit, TemplateRef} from '@angular/core';
import { Person } from 'src/app/models/Person';
import { PersonService } from 'src/app/services/person.service';
import { Router } from '@angular/router';
import { TokenService } from '../../services/security/token.service';
import { BsModalRef, BsModalService} from 'ngx-bootstrap/modal';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  person: Person[] = [];

  id: any;
  name: string = "";
  profileImg: string = "";
  texto: string = ";"
  description: string = "";
  backImag: string = "";
  mail: string = "";
  city: string = "";
  country: string = "";
  modalRef?: BsModalRef;
  isLogged =false;
  isAdmin: boolean=false;
  errMsj: string="";



  constructor(private personService: PersonService, private router: Router, private tokenService: TokenService, private modalService: BsModalService,   private toastr: ToastrService) {

    this.personService.getPerson().subscribe((person) => {
      console.log(person);
      this.person = person;
    });

  }

  openModal1(template1: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template1);
  }


  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    this.isAdmin = this.tokenService.isAdmin();

 }


  signout(): void {
    this.tokenService.logOut();
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.navigate([this.router.url]);
  }

  editarPersona(person: Person) {
    this.id = person.id;
    this.name = person.name;
    this.description = person.description;
    this.city = person.city;
    this.country = person.country;
    this.personService.editPersona(person).subscribe();
    this.modalService.hide();
  }

  print(){
    window.print();
  }
  logged(){
    return this.tokenService.isLogged();
  }

}


