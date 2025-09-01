package com.discord.models.ktx;

import androidx.core.app.Person;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelUserExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/models/user/User;", "Landroidx/core/app/Person;", "toPerson", "(Lcom/discord/models/user/User;)Landroidx/core/app/Person;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.ktx.ModelUserExtensionsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelUserExtensions {
    public static final Person toPerson(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$toPerson");
        Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(String.valueOf(user.getId())).setBot(user.isBot()).build();
        Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …t(isBot)\n        .build()");
        return personBuild;
    }
}
