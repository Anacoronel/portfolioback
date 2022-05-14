import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDto } from 'src/app/models/Jwt-Dto';
import { NewUser } from 'src/app/models/New-User';
import { LoginUser } from 'src/app/models/LoginUser';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = environment.apiUrl;

  
  constructor(private http: HttpClient) { }

  public new(newUser: NewUser): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/auth/new', newUser);
  }

  public login(loginUser: LoginUser): Observable<JwtDto> {
    return this.http.post<JwtDto>(this.apiUrl + '/auth/login', loginUser)
  }

 // public refresh(dto: JwtDto): Observable<JwtDto> {
 //   return this.http.post<JwtDto>(this.apiUrl + '/auth/refresh', dto);
 // }
}
