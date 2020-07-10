import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
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
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  {
    path: 'admin-dashboard', component: AdminLayoutComponent, children: [
      { path: '', component: AdminDashboardComponent },
      { path: 'users', component: UsersComponent },
      { path: 'work-in-progress', component: WorkInProgressComponent },
      { path: 'descriptions', component: DescriptionsComponent },
      { path: 'documents', component: DocumentsComponent },
      { path: 'folders', component: FoldersComponent },
      { path: 'interestgroups', component: InterestgroupsComponent },
      { path: 'interests', component: InterestsComponent },
      { path: 'libraries', component: LibrariesComponent },
      { path: 'searchconnections', component: SearchconnectionsComponent },
      { path: 'subscribes', component: SubscribesComponent },
      { path: 'tags', component: TagsComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }