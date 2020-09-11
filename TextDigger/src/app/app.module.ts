import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
