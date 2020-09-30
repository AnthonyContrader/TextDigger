import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { LoginModule } from 'src/app/login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';

import { AppComponent } from './app.component';
@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule, 
    AppRoutingModule,
    LoginModule,
    HttpClientModule,
    LayoutModule,
    AdminModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
