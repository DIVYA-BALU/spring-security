package com.divya.jwtauthentication.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "role-permissions")
public class RolePermissions {
    @Id
    String _id;

    @Field("role-id")
    @DocumentReference(collection = "roles")
    Role roleId;

    @DocumentReference(collection = "permissions")
    @Field("permission-id")
    Permissions permissionId;
}
