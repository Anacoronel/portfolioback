import { Person } from "./Person";


export interface Experience {
    id: any;
    position: string;
    company: string;
    startTime:string;
    endTime:string;
    link: string;
    person: Person;
}