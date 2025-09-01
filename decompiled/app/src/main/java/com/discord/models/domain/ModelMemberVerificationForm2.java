package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelMemberVerificationForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelMemberVerificationForm$FormField$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelMemberVerificationForm2<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $choices;
    public final /* synthetic */ Ref$ObjectRef $fieldType;
    public final /* synthetic */ Ref$ObjectRef $label;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$BooleanRef $required;
    public final /* synthetic */ Ref$ObjectRef $response;
    public final /* synthetic */ Ref$ObjectRef $values;

    /* compiled from: ModelMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelMemberVerificationForm$FormField$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<String> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ String get() {
            return get2();
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        /* renamed from: get, reason: avoid collision after fix types in other method */
        public final String get2() {
            return ModelMemberVerificationForm2.this.$reader.nextString("");
        }
    }

    /* compiled from: ModelMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelMemberVerificationForm$FormField$Parser$parse$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Model.JsonReader.ItemFactory<String> {
        public AnonymousClass2() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ String get() {
            return get2();
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        /* renamed from: get, reason: avoid collision after fix types in other method */
        public final String get2() {
            return ModelMemberVerificationForm2.this.$reader.nextString("");
        }
    }

    public ModelMemberVerificationForm2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.$fieldType = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$label = ref$ObjectRef2;
        this.$required = ref$BooleanRef;
        this.$values = ref$ObjectRef3;
        this.$choices = ref$ObjectRef4;
        this.$response = ref$ObjectRef5;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -823812830:
                    if (str.equals("values")) {
                        Ref$ObjectRef ref$ObjectRef = this.$values;
                        T t = (T) this.$reader.nextList(new AnonymousClass1());
                        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { reader.nextString(\"\") }");
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case -393139297:
                    if (str.equals("required")) {
                        this.$required.element = this.$reader.nextBoolean(false);
                        return;
                    }
                    break;
                case -340323263:
                    if (str.equals("response")) {
                        T t2 = this.$fieldType.element;
                        if (t2 == null) {
                            Intrinsics3.throwUninitializedPropertyAccessException("fieldType");
                        }
                        String str2 = (String) t2;
                        if (str2.hashCode() == 1121961648 && str2.equals("MULTIPLE_CHOICE")) {
                            this.$response.element = (T) Integer.valueOf(this.$reader.nextInt(-1));
                            return;
                        } else {
                            Ref$ObjectRef ref$ObjectRef2 = this.$response;
                            T t3 = (T) this.$reader.nextString("");
                            Intrinsics3.checkNotNullExpressionValue(t3, "reader.nextString(\"\")");
                            ref$ObjectRef2.element = t3;
                            return;
                        }
                    }
                    break;
                case 102727412:
                    if (str.equals("label")) {
                        Ref$ObjectRef ref$ObjectRef3 = this.$label;
                        T t4 = (T) this.$reader.nextString("");
                        Intrinsics3.checkNotNullExpressionValue(t4, "reader.nextString(\"\")");
                        ref$ObjectRef3.element = t4;
                        return;
                    }
                    break;
                case 576861023:
                    if (str.equals("field_type")) {
                        Ref$ObjectRef ref$ObjectRef4 = this.$fieldType;
                        T t5 = (T) this.$reader.nextString("");
                        Intrinsics3.checkNotNullExpressionValue(t5, "reader.nextString(\"\")");
                        ref$ObjectRef4.element = t5;
                        return;
                    }
                    break;
                case 751720178:
                    if (str.equals("choices")) {
                        Ref$ObjectRef ref$ObjectRef5 = this.$choices;
                        T t6 = (T) this.$reader.nextList(new AnonymousClass2());
                        Intrinsics3.checkNotNullExpressionValue(t6, "reader.nextList { reader.nextString(\"\") }");
                        ref$ObjectRef5.element = t6;
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
