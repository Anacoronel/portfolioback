import { Language } from "./Language";


export class Person {
    id: any;
    name: string="";
    profileImg: string="";
    backImg: string="";
    mail: string="anacoronel@homtmail.com";
    description:string="";
    city:string="";
    country:string="";
    
 
    constructor(id:any, name:string, profileImg:string, backImg:string, mail:string, description:string,city:string, country:string){

        this.id=id;
        this.name=name;
        this.profileImg=profileImg;
        this.backImg=backImg;
        this.mail=mail;
        this.description=description;
        this.country=country;
        this.city=city;
       


    }

   
}