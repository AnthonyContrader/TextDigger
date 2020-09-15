import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { LoginModule } from 'src/app/login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';

import { AppComponent } from './app.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { DocumentsComponent } from './admin/documents/documents.component';
import { FoldersComponent } from './admin/folders/folders.component';
import { InterestgroupsComponent } from './admin/interestgroups/interestgroups.component';
import { InterestsComponent } from './admin/interests/interests.component';
import { LibrariesComponent } from './admin/libraries/libraries.component';
import { SearchconnectionsComponent } from './admin/searchconnections/searchconnections.component';
import { SubscribesComponent } from './admin/subscribes/subscribes.component';
import { TagsComponent } from './admin/tags/tags.component';
import { UsersComponent } from './admin/users/users.component';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    DocumentsComponent,
    FoldersComponent,
    InterestgroupsComponent,
    InterestsComponent,
    LibrariesComponent,
    SearchconnectionsComponent,
    SubscribesComponent,
    TagsComponent,
    UsersComponent,
    AdminLayoutComponent,
    LoginComponent,
    ProfileComponent
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
