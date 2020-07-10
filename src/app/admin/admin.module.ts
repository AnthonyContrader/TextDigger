import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { DescriptionsComponent } from './descriptions/descriptions.component';
import { DocumentsComponent } from './documents/documents.component';
import { FoldersComponent } from './folders/folders.component';
import { InterestgroupsComponent } from './interestgroups/interestgroups.component';
import { InterestsComponent } from './interests/interests.component';
import { LibrariesComponent } from './libraries/libraries.component';
import { SearchconnectionsComponent } from './searchconnections/searchconnections.component';
import { SubscribesComponent } from './subscribes/subscribes.component';
import { TagsComponent } from './tags/tags.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, DescriptionsComponent, DocumentsComponent, FoldersComponent, InterestgroupsComponent,
    InterestsComponent, LibrariesComponent, SearchconnectionsComponent, SubscribesComponent, TagsComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
