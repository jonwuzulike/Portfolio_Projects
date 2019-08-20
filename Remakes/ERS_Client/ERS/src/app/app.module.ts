import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AgentComponent } from './agent-dashboard/agent/agent.component';
import { ManagerComponent } from './manager-dashboard/manager/manager.component';


const appRoutes: Routes = [
  {path:"", component: HomeComponent},
  {path: "login", component: LoginComponent},
  {path: "agent", component: AgentComponent},
  {path: "manager", component: ManagerComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AgentComponent,
    ManagerComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
