# Documentación de Service Security

## Person

### ** POST => http://localhost:9000/service-security/v1/api/person **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T20:40:55.434Z",
        "updatedAt": "2024-02-16T20:40:55.434Z",
        "deletedAt": "2024-02-16T20:40:55.434Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "phone": "string",
        "dateOfBirth": "2024-02-16",
        "gender": "string",
        "address": "string"
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "firstName": "Jhon",
        "lastName": "Corredor",
        "email": "jhon@gmailcom",
        "phone": "3153306405",
        "dateOfBirth": "2006-01-29",
        "gender": "M",
        "address": "Calle 80"
    }
```

### ** PUT => http://localhost:9000/service-security/v1/api/person/1 **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T20:40:55.434Z",
        "updatedAt": "2024-02-16T20:40:55.434Z",
        "deletedAt": "2024-02-16T20:40:55.434Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "phone": "string",
        "dateOfBirth": "2024-02-16",
        "gender": "string",
        "address": "string"
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "firstName": "Jhon Alexander",
        "lastName": "Corredor Medina",
        "email": "jesus@gmailcom",
        "phone": "3153306405",
        "dateOfBirth": "2006-01-29",
        "gender": "M",
        "address": "Calle 80"
    }
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/person **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/person/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/person/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************

## User

### ** POST => http://localhost:9000/service-security/v1/api/user **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:21:18.478Z",
  "updatedAt": "2024-02-16T21:21:18.478Z",
  "deletedAt": "2024-02-16T21:21:18.478Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "username": "string",
  "password": "string",
  "person": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:21:18.478Z",
    "updatedAt": "2024-02-16T21:21:18.478Z",
    "deletedAt": "2024-02-16T21:21:18.478Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "phone": "string",
    "dateOfBirth": "2024-02-16",
    "gender": "string",
    "address": "string"
  }
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "username": "jhonCorredor",
  "password": "4564",
  "person": {
    "id": 1
  }
}
```

### ** PUT => http://localhost:9000/service-security/v1/api/user/1 **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:21:18.478Z",
  "updatedAt": "2024-02-16T21:21:18.478Z",
  "deletedAt": "2024-02-16T21:21:18.478Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "username": "string",
  "password": "string",
  "person": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:21:18.478Z",
    "updatedAt": "2024-02-16T21:21:18.478Z",
    "deletedAt": "2024-02-16T21:21:18.478Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "phone": "string",
    "dateOfBirth": "2024-02-16",
    "gender": "string",
    "address": "string"
  }
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "username": "jhonCorredor",
  "password": "4564jhon",
  "person": {
    "id": 1
  }
}
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/user **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/user/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/user/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************

## Role

### ** POST => http://localhost:9000/service-security/v1/api/module-role **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:38:16.176Z",
  "updatedAt": "2024-02-16T21:38:16.176Z",
  "deletedAt": "2024-02-16T21:38:16.176Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "name": "string",
  "description": "string"
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "name": "Admin",
  "description": "administrador"
}
```

### ** PUT => http://localhost:9000/service-security/v1/api/role/1 **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:38:16.176Z",
  "updatedAt": "2024-02-16T21:38:16.176Z",
  "deletedAt": "2024-02-16T21:38:16.176Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "name": "string",
  "description": "string"
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "name": "Admin",
  "description": "Administrador"
}
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/role **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/role/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/role/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************

# Documentación de Service Security
# Use-Rol

### * POST => http://localhost:9000/service-security/v1/api/use_role *

#### json normal
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:43:21.337Z",
  "updatedAt": "2024-02-16T21:43:21.337Z",
  "deletedAt": "2024-02-16T21:43:21.337Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "user": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:43:21.337Z",
    "updatedAt": "2024-02-16T21:43:21.337Z",
    "deletedAt": "2024-02-16T21:43:21.337Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "username": "string",
    "password": "string",
    "person": {
      "id": 0,
      "state": true,
      "createdAt": "2024-02-16T21:43:21.337Z",
      "updatedAt": "2024-02-16T21:43:21.337Z",
      "deletedAt": "2024-02-16T21:43:21.337Z",
      "createdBy": 0,
      "updatedBy": 0,
      "deletedBy": 0,
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "phone": "string",
      "dateOfBirth": "2024-02-16",
      "gender": "string",
      "address": "string"
    }
  },
  "role": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:43:21.337Z",
    "updatedAt": "2024-02-16T21:43:21.337Z",
    "deletedAt": "2024-02-16T21:43:21.337Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "name": "string",
    "description": "string"
  }
}
```

#### json a enviar
```json
    {
  "state": true,
  "user": {
    "id": 1
  },
  "role": {
    "id": 1
  }
}
```

### * PUT => http://localhost:9000/service-security/v1/api/use_role/1 *

#### json normal
```json
   {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:43:21.337Z",
  "updatedAt": "2024-02-16T21:43:21.337Z",
  "deletedAt": "2024-02-16T21:43:21.337Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "user": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:43:21.337Z",
    "updatedAt": "2024-02-16T21:43:21.337Z",
    "deletedAt": "2024-02-16T21:43:21.337Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "username": "string",
    "password": "string",
    "person": {
      "id": 0,
      "state": true,
      "createdAt": "2024-02-16T21:43:21.337Z",
      "updatedAt": "2024-02-16T21:43:21.337Z",
      "deletedAt": "2024-02-16T21:43:21.337Z",
      "createdBy": 0,
      "updatedBy": 0,
      "deletedBy": 0,
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "phone": "string",
      "dateOfBirth": "2024-02-16",
      "gender": "string",
      "address": "string"
    }
  },
  "role": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:43:21.337Z",
    "updatedAt": "2024-02-16T21:43:21.337Z",
    "deletedAt": "2024-02-16T21:43:21.337Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "name": "string",
    "description": "string"
  }
}
```

#### json a enviar
```json
   {
  "state": true,
  "user": {
    "id": 1
  },
  "role": {
    "id": 1
  }
}
```

### * Get (All) => http://localhost:9000/service-security/v1/api/use_role *

#### json normal
```json
    {
       
    }
```

#### json a enviar
```json
    {
      
    }
```

### * Get (Id) => http://localhost:9000/service-security/v1/api/use_role/1 *

#### json normal
```json
    {
       
    }
```

#### json a enviar
```json
    {
      
    }
```

### * Delete (Id) => http://localhost:9000/service-security/v1/api/use_role/1 *

#### json normal
```json
    {
       
    }
```

#### json a enviar
```json
    {
      
    }
```
# ********************************************



## module

### * POST => http://localhost:9000/service-security/v1/api/module *

#### json normal
```json
{
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:47:13.340Z",
  "updatedAt": "2024-02-16T21:47:13.341Z",
  "deletedAt": "2024-02-16T21:47:13.341Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "name": "string",
  "description": "string",
  "route": "string"
}
```

#### json a enviar
```json
{
  "state": true,
  "name": "modulo",
  "description": "modulo",
  "route": "link@example"
}
```

### * PUT => http://localhost:9000/service-security/v1/api/module/1 *

#### json normal
```json
   {

  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:47:13.340Z",
  "updatedAt": "2024-02-16T21:47:13.341Z",
  "deletedAt": "2024-02-16T21:47:13.341Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "name": "string",
  "description": "string",
  "route": "string"

  }
```

#### json a enviar
```json
{
  "id": 1,
  "state": true,
  "name": "moduloactual",
  "description": "moduloactual",
  "route": "link@example"
}
```

### * Get (All) => http://localhost:9000/service-security/v1/api/module *

#### json normal
```json
    {
       
    }
```

#### json a enviar
```json
    {
      
    }
```

### * Get (Id) => http://localhost:9000/service-security/v1/api/module/1 *

#### json normal
```json
    {
       
    }
```

#### json a enviar
```json
    {
      
    }
```

### * Delete (Id) => http://localhost:9000/service-security/v1/api/module/1 *

#### json normal
```json
    {
       
    }
```

#### json a enviar
```json
    {
      
    }
```
    
# ********************************************

## Module-Role

### ** POST => http://localhost:9000/service-security/v1/api/module_role **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:42:44.891Z",
  "updatedAt": "2024-02-16T21:42:44.891Z",
  "deletedAt": "2024-02-16T21:42:44.891Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "module": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:42:44.891Z",
    "updatedAt": "2024-02-16T21:42:44.891Z",
    "deletedAt": "2024-02-16T21:42:44.891Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "username": "string",
    "password": "string",
    "person": {
      "id": 0,
      "state": true,
      "createdAt": "2024-02-16T21:42:44.891Z",
      "updatedAt": "2024-02-16T21:42:44.891Z",
      "deletedAt": "2024-02-16T21:42:44.891Z",
      "createdBy": 0,
      "updatedBy": 0,
      "deletedBy": 0,
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "phone": "string",
      "dateOfBirth": "2024-02-16",
      "gender": "string",
      "address": "string"
    }
  },
  "role": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:42:44.891Z",
    "updatedAt": "2024-02-16T21:42:44.891Z",
    "deletedAt": "2024-02-16T21:42:44.891Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "name": "string",
    "description": "string"
  }
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "module": {
    "id": 1
  },
  "role": {
    "id": 1
  }
}
```

### ** PUT => http://localhost:9000/service-security/v1/api/module_role/1 **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T21:42:44.891Z",
  "updatedAt": "2024-02-16T21:42:44.891Z",
  "deletedAt": "2024-02-16T21:42:44.891Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "module": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:42:44.891Z",
    "updatedAt": "2024-02-16T21:42:44.891Z",
    "deletedAt": "2024-02-16T21:42:44.891Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "username": "string",
    "password": "string",
    "person": {
      "id": 0,
      "state": true,
      "createdAt": "2024-02-16T21:42:44.891Z",
      "updatedAt": "2024-02-16T21:42:44.891Z",
      "deletedAt": "2024-02-16T21:42:44.891Z",
      "createdBy": 0,
      "updatedBy": 0,
      "deletedBy": 0,
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "phone": "string",
      "dateOfBirth": "2024-02-16",
      "gender": "string",
      "address": "string"
    }
  },
  "role": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T21:42:44.891Z",
    "updatedAt": "2024-02-16T21:42:44.891Z",
    "deletedAt": "2024-02-16T21:42:44.891Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "name": "string",
    "description": "string"
  }
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "module": {
    "id": 1
  },
  "role": {
    "id": 1
  }
}
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/module_role **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/module_role/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/module_role/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************

## View

### ** POST => http://localhost:9000/service-security/v1/api/view **

#### **json normal**
```json
   {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T22:03:00.695Z",
  "updatedAt": "2024-02-16T22:03:00.695Z",
  "deletedAt": "2024-02-16T22:03:00.695Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "name": "string",
  "description": "string",
  "route": "string"
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "name": "view1",
  "description": "vista inicial",
  "route": "link@example"
}
```

### ** PUT => http://localhost:9000/service-security/v1/api/view/1 **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T22:03:00.695Z",
  "updatedAt": "2024-02-16T22:03:00.695Z",
  "deletedAt": "2024-02-16T22:03:00.695Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "name": "string",
  "description": "string",
  "route": "string"
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "name": "view1",
  "description": "Vista principal",
  "route": "link@example"
}
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/view **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/view/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/view/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************

## Module-View

### ** POST => http://localhost:9000/service-security/v1/api/module_view **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T22:10:24.395Z",
  "updatedAt": "2024-02-16T22:10:24.395Z",
  "deletedAt": "2024-02-16T22:10:24.395Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "module": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T22:10:24.395Z",
    "updatedAt": "2024-02-16T22:10:24.395Z",
    "deletedAt": "2024-02-16T22:10:24.395Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "username": "string",
    "password": "string",
    "person": {
      "id": 0,
      "state": true,
      "createdAt": "2024-02-16T22:10:24.395Z",
      "updatedAt": "2024-02-16T22:10:24.395Z",
      "deletedAt": "2024-02-16T22:10:24.395Z",
      "createdBy": 0,
      "updatedBy": 0,
      "deletedBy": 0,
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "phone": "string",
      "dateOfBirth": "2024-02-16",
      "gender": "string",
      "address": "string"
    }
  },
  "view": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T22:10:24.395Z",
    "updatedAt": "2024-02-16T22:10:24.395Z",
    "deletedAt": "2024-02-16T22:10:24.395Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "name": "string",
    "description": "string"
  }
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "module": {
    "id": 1
  },
  "view": {
    "id": 1
  }
}
```

### ** PUT => http://localhost:9000/service-security/v1/api/module_view/1 **

#### **json normal**
```json
    {
  "id": 0,
  "state": true,
  "createdAt": "2024-02-16T22:10:24.395Z",
  "updatedAt": "2024-02-16T22:10:24.395Z",
  "deletedAt": "2024-02-16T22:10:24.395Z",
  "createdBy": 0,
  "updatedBy": 0,
  "deletedBy": 0,
  "module": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T22:10:24.395Z",
    "updatedAt": "2024-02-16T22:10:24.395Z",
    "deletedAt": "2024-02-16T22:10:24.395Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "username": "string",
    "password": "string",
    "person": {
      "id": 0,
      "state": true,
      "createdAt": "2024-02-16T22:10:24.395Z",
      "updatedAt": "2024-02-16T22:10:24.395Z",
      "deletedAt": "2024-02-16T22:10:24.395Z",
      "createdBy": 0,
      "updatedBy": 0,
      "deletedBy": 0,
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "phone": "string",
      "dateOfBirth": "2024-02-16",
      "gender": "string",
      "address": "string"
    }
  },
  "view": {
    "id": 0,
    "state": true,
    "createdAt": "2024-02-16T22:10:24.395Z",
    "updatedAt": "2024-02-16T22:10:24.395Z",
    "deletedAt": "2024-02-16T22:10:24.395Z",
    "createdBy": 0,
    "updatedBy": 0,
    "deletedBy": 0,
    "name": "string",
    "description": "string"
  }
}
```

#### **json a enviar**
```json
    {
  "state": true,
  "module": {
    "id": 1
  },
  "view": {
    "id": 1
  }
}
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/module_view **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/module_view/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/module_view/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************