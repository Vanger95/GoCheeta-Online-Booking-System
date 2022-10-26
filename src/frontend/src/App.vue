<template>
  <v-app id="inspire">
      <v-navigation-drawer permanent
      v-model="drawer"
              app>
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title class="text-h6">
                  Application
                </v-list-item-title>
                <v-list-item-subtitle>
                  subtext
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>

            <v-divider></v-divider>

            <v-list
              dense
              nav
            >
              <v-list-item
                v-for="item in items"
                :key="item.title"
                :to="item.to"
                link
              >
                <v-list-item-icon>
                  <v-icon>{{ item.icon }}</v-icon>
                </v-list-item-icon>

                <v-list-item-content>
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-navigation-drawer>

      <v-app-bar app>
        <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

        <v-toolbar-title>Application</v-toolbar-title>
      </v-app-bar>

      <v-main>
        <v-container fluid>

              <!-- If using vue-router -->
              <router-view></router-view>
            </v-container>
      </v-main>
    </v-app>
</template>

<script>

 export default {
    data: () => ({ drawer: null,
     items: [
               { title: 'Dashboard', icon: 'mdi-view-dashboard', to:"/" },
               { title: 'Add Reservation', icon: 'mdi-train-car', to:"/reservation"},
               { title: 'Add New Customer', icon: 'mdi-help-box', to:"/addNewCustommer" },
               { title: 'About', icon: 'mdi-help-box', to:"/about" },
             ],
     }),
  }
</script>
