package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelMemberVerificationForm;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelMemberVerificationForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelMemberVerificationForm$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelMemberVerificationForm3<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $formFields;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $version;

    /* compiled from: ModelMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelMemberVerificationForm$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<ModelMemberVerificationForm.FormField> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelMemberVerificationForm.FormField get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelMemberVerificationForm.FormField get() {
            return ModelMemberVerificationForm.FormField.Parser.INSTANCE.parse(ModelMemberVerificationForm3.this.$reader);
        }
    }

    public ModelMemberVerificationForm3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$version = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$formFields = ref$ObjectRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -708425068) {
                if (iHashCode == 351608024 && str.equals("version")) {
                    Ref$ObjectRef ref$ObjectRef = this.$version;
                    T t = (T) this.$reader.nextString("");
                    Intrinsics3.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                    ref$ObjectRef.element = t;
                    return;
                }
            } else if (str.equals("form_fields")) {
                Ref$ObjectRef ref$ObjectRef2 = this.$formFields;
                T t2 = (T) this.$reader.nextList(new AnonymousClass1());
                Intrinsics3.checkNotNullExpressionValue(t2, "reader.nextList { FormField.Parser.parse(reader) }");
                ref$ObjectRef2.element = t2;
                return;
            }
        }
        this.$reader.skipValue();
    }
}
