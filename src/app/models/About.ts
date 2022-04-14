import{Person} from './Person';
export class About{
    id: any;
    text: string="";
    person:Person[]=[];
constructor(id:any, text:string, person:Person[]){
        this.id=id;
        this.text=text;
        this.person=person;
    }
}