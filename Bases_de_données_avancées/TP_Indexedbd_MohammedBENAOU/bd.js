MyProject = {};
MyProject.openDatabase = function () {
    var request = indexedDB.open("MyBase", 2);
    request.onerror = function (event) {
	    console.log("Error");
    }
    request.onsuccess = function (event) {
	    //console.log(event);
        MyProject.db=event.target.result;
        console.log("La base de données est ouvete ");
    }
    request.onupgradeneeded = function (event) {
                var db = event.target.result;
                //l'option autoIncrement définie à true.   
                var objectStore = db.createObjectStore("Person", {keyPath: "id",autoIncrement:true});
              if (event.oldVersion < 3 ) {
                // on peut avoir des doublons  alors on n'utilise pas d'index unique.
                this.transaction.objectStore("Person").createIndex("name", "name",{unique: false});}
              if (event.oldVersion < 4 ) {
                // assurer que deux personnes n'auront pas la même adresse mail, donc nous utilisons un index unique.
                this.transaction.objectStore("Person").createIndex("address", "email",{unique: true});}
                // Création d'un autre objet appelé "Book"
                if (event.oldVersion <5){
                var objectStore = db.createObjectStore("Book", {keyPath: "id",autoIncrement: true});
                this.transaction.objectStore("Book").createIndex("bookName", "bookName",{unique: false});}
               // Création d'un autre objet appelé "Book"
               if (event.oldVersion <6){
                var objectStore = db.createObjectStore("Emprunt", {keyPath: "id",autoIncrement: true});
                this.transaction.objectStore("Emprunt").createIndex("idperson", "idperson");
                this.transaction.objectStore("Emprunt").createIndex("idbook", "idbook");}
     }       

};
MyProject.deleteDatabase = function () {
    var request = indexedDB.deleteDatabase("MyBase");
    request.onerror = function (event) {
        console.log("Erreur lors de la suppression de la base");
    }
    request.onsuccess = function (event) {
        MyProject.db=event.target.result;
         console.log("Suppression de la base réussie");
    }
};
MyProject.insertPerson = function(person){
/*    const personData = [
   { name: "Gopal K Varma", email: "contact@tutorialspoint.com" },
   { name: "Prasad", email: "prasad@tutorialspoint.com" }
];*/
var request = indexedDB.open("MyBase");
var transaction = MyProject.db.transaction(["Person"], "readwrite");
var objectStore = transaction.objectStore("Person");
for(var i in person){
var request = objectStore.add(person[i]);
}

 request.onerror = function(event){
    console.log("Erreur d'ajout");
  }

  request.onsuccess = function(event){
    console.log("Personne(s) est ajouté à la base de données");
  }

}
// la recherche par l'identifiant passé en paramètre 
MyProject.searchPersonById = function(id){
  var T = MyProject.db.transaction(["Person"], "readonly");
  var objectStore = T.objectStore("Person");
  var request = objectStore.get(id);

  request.onerror = function(event){
    console.log("Erreur de recherche");
  }

  request.onsuccess = function(event){
    // si le résultat est inconnu donc la personne n'existe pas
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
      console.log("La personne trouvée => Name: " + request.result.name + ", Email: " + request.result.email);
    }
  }
}
//la recherche par email passé en paramètre 
MyProject.searchPersonByEmail = function(email){
  var T = MyProject.db.transaction(["Person"], "readonly");
  var objectStore = T.objectStore("Person");
  var request = objectStore.index("address").get(email);
  request.onerror = function(event){
    console.log("erreur  de recherche ");
  }

  request.onsuccess = function(event){
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
      console.log("La personne trouvée => Name: " + request.result.name + ", Email: " + request.result.email);
    }
  }
}
// la recherche par le nom passé en paramètre 
MyProject.searchPersonByName = function (name){
  var T = MyProject.db.transaction(["Person"], "readonly");
  var objectStore = T.objectStore("Person");
  var request = objectStore.index("name").get(name);
  request.onerror = function(event){
    console.log("erreur  de recherche ");
  }
  request.onsuccess = function(event){
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
            console.log("La personne trouvée => Name: " + request.result.name + ", Email: " + request.result.email);
    }
  } 
}
//Création du schéma des livres
MyProject.insertBook = function(Book){
  //const name = [ { bookName: "le rouge et le noir"},{ bookName: "candide"} ];
  var request = indexedDB.open("MyBase");
  var P = MyProject.db.transaction(["Book"], "readwrite");
  var objectStore = P.objectStore("Book");
  for(var i in Book){
  var request = objectStore.add(Book[i]);
 } 
  request.onerror = function(event){
    console.log("Erreur d'ajout");
  }

  request.onsuccess = function(event){
    console.log("Livre(s) est ajouté à la base de données");
  }
    
};

MyProject.searchBookById = function(id){
  var T = MyProject.db.transaction(["Book"], "readonly");
  var objectStore = T.objectStore("Book");
  var request = objectStore.get(id);

  request.onerror = function(event){
    console.log("Erreur de recherche");
  }

  request.onsuccess = function(event){
    // si le résultat est inconnu donc la personne n'existe pas
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
      console.log("Le nom du livre est : " + request.result.bookName);
    }
  }
}
  MyProject.insertBorrow = function (idperson,idbook){
  var request = indexedDB.open("MyBase");
  var P = MyProject.db.transaction(["Emprunt"], "readwrite");
  var objectStore = P.objectStore("Emprunt");
  var borow ={idperson:idperson,idbook:idbook}
    var request = objectStore.add(borow);  

    request.onerror = function(event){
    console.log("Erreur d'ajout");
    }

    request.onsuccess = function(event){
    console.log("un nouvel emprunt est ajouté à la base");
    }
  
}
MyProject.searchBorrowByBookId = function (idbook){
  //var db = event.target.result;
  var T = MyProject.db.transaction(["Emprunt"], "readonly");
  var objectStore = T.objectStore("Emprunt");
  var request = objectStore.index("idbook").get(idbook);
  request.onerror = function(event){
    console.log("Erreur de recherche");
  }
  request.onsuccess = function(event){
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
          console.log("L'emprunteur : ");
           MyProject.searchPersonById(request.result.idperson); 
    }
  }
}

MyProject.searchBorrowByPersonId = function(idperson){
  var T = MyProject.db.transaction(["Emprunt"], "readonly");
  var objectStore = T.objectStore("Emprunt");
  var request = objectStore.index("idperson").get(idperson);
  request.onerror = function(event){
    console.log("Erreur de recherche");
  }
  request.onsuccess = function(event){
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
        //console.log("La personne a emprunté  : "+request.result.idbook);
        for (var i in request.result.idbook){ 
          console.log("La personne a emprunté  : ");
           MyProject.searchBookById(request.result.idbook[i]); }
    }
  }
}

MyProject.searchBorrowByPersonEmail = function (email){
  var T = MyProject.db.transaction(["Person"], "readonly");
  var objectStore = T.objectStore("Person");
  var request = objectStore.index("address").get(email);
  request.onerror = function(event){
    console.log("Erreur de recherche");
  }
  request.onsuccess = function(event){
    if (typeof this.result == "undefined") {
      console.log("Cet identifiant n'existe pas dans la base de données");
    } else {
        MyProject.searchBorrowByPersonId(request.result.id);
    }
  }
}


