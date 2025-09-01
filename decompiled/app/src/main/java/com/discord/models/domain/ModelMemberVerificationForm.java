package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelMemberVerificationForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u001d\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm;", "", "", "isFormOutdated", "()Z", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "component2", "()Ljava/util/List;", "version", "formFields", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/models/domain/ModelMemberVerificationForm;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFormFields", "Ljava/lang/String;", "getVersion", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "FormField", "MemberVerificationFieldType", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationForm {
    private final List<FormField> formFields;
    private final String version;

    /* compiled from: ModelMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u00010BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJX\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010%R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u0004R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b(\u0010\u000bR\u0013\u0010,\u001a\u00020)8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b-\u0010\u0004¨\u00061"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "", "component4", "()Ljava/util/List;", "component5", "component6", "()Ljava/lang/Object;", "fieldType", "label", "required", "values", "choices", "response", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/lang/Object;)Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getRequired", "Ljava/util/List;", "getValues", "Ljava/lang/Object;", "getResponse", "setResponse", "(Ljava/lang/Object;)V", "Ljava/lang/String;", "getLabel", "getChoices", "Lcom/discord/models/domain/ModelMemberVerificationForm$MemberVerificationFieldType;", "getMemberVerificationFieldType", "()Lcom/discord/models/domain/ModelMemberVerificationForm$MemberVerificationFieldType;", "memberVerificationFieldType", "getFieldType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/lang/Object;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FormField {
        private final List<String> choices;
        private final String fieldType;
        private final String label;
        private final boolean required;
        private Object response;
        private final List<String> values;

        /* compiled from: ModelMemberVerificationForm.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm$FormField$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Parser implements Model.Parser<FormField> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ FormField parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public FormField parse(Model.JsonReader reader) throws IOException {
                Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
                ref$ObjectRefC0.element = null;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = false;
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = null;
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = null;
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                ref$ObjectRef4.element = null;
                reader.nextObject(new ModelMemberVerificationForm2(ref$ObjectRefC0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4));
                T t = ref$ObjectRefC0.element;
                if (t == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("fieldType");
                }
                String str = (String) t;
                T t2 = ref$ObjectRef.element;
                if (t2 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("label");
                }
                String str2 = (String) t2;
                boolean z2 = ref$BooleanRef.element;
                T t3 = ref$ObjectRef2.element;
                if (t3 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("values");
                }
                List list = (List) t3;
                T t4 = ref$ObjectRef3.element;
                if (t4 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("choices");
                }
                List list2 = (List) t4;
                T t5 = ref$ObjectRef4.element;
                if (t5 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("response");
                }
                return new FormField(str, str2, z2, list, list2, t5);
            }
        }

        public FormField(String str, String str2, boolean z2, List<String> list, List<String> list2, Object obj) {
            Intrinsics3.checkNotNullParameter(str, "fieldType");
            Intrinsics3.checkNotNullParameter(str2, "label");
            Intrinsics3.checkNotNullParameter(list, "values");
            Intrinsics3.checkNotNullParameter(list2, "choices");
            Intrinsics3.checkNotNullParameter(obj, "response");
            this.fieldType = str;
            this.label = str2;
            this.required = z2;
            this.values = list;
            this.choices = list2;
            this.response = obj;
        }

        public static /* synthetic */ FormField copy$default(FormField formField, String str, String str2, boolean z2, List list, List list2, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = formField.fieldType;
            }
            if ((i & 2) != 0) {
                str2 = formField.label;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                z2 = formField.required;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                list = formField.values;
            }
            List list3 = list;
            if ((i & 16) != 0) {
                list2 = formField.choices;
            }
            List list4 = list2;
            if ((i & 32) != 0) {
                obj = formField.response;
            }
            return formField.copy(str, str3, z3, list3, list4, obj);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFieldType() {
            return this.fieldType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getRequired() {
            return this.required;
        }

        public final List<String> component4() {
            return this.values;
        }

        public final List<String> component5() {
            return this.choices;
        }

        /* renamed from: component6, reason: from getter */
        public final Object getResponse() {
            return this.response;
        }

        public final FormField copy(String fieldType, String label, boolean required, List<String> values, List<String> choices, Object response) {
            Intrinsics3.checkNotNullParameter(fieldType, "fieldType");
            Intrinsics3.checkNotNullParameter(label, "label");
            Intrinsics3.checkNotNullParameter(values, "values");
            Intrinsics3.checkNotNullParameter(choices, "choices");
            Intrinsics3.checkNotNullParameter(response, "response");
            return new FormField(fieldType, label, required, values, choices, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormField)) {
                return false;
            }
            FormField formField = (FormField) other;
            return Intrinsics3.areEqual(this.fieldType, formField.fieldType) && Intrinsics3.areEqual(this.label, formField.label) && this.required == formField.required && Intrinsics3.areEqual(this.values, formField.values) && Intrinsics3.areEqual(this.choices, formField.choices) && Intrinsics3.areEqual(this.response, formField.response);
        }

        public final List<String> getChoices() {
            return this.choices;
        }

        public final String getFieldType() {
            return this.fieldType;
        }

        public final String getLabel() {
            return this.label;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final MemberVerificationFieldType getMemberVerificationFieldType() {
            String str = this.fieldType;
            switch (str.hashCode()) {
                case -708597224:
                    if (str.equals("TEXT_INPUT")) {
                        return MemberVerificationFieldType.TEXT_INPUT;
                    }
                    break;
                case 79712615:
                    if (str.equals("TERMS")) {
                        return MemberVerificationFieldType.TERMS;
                    }
                    break;
                case 440916302:
                    if (str.equals("PARAGRAPH")) {
                        return MemberVerificationFieldType.PARAGRAPH;
                    }
                    break;
                case 1121961648:
                    if (str.equals("MULTIPLE_CHOICE")) {
                        return MemberVerificationFieldType.MULTIPLE_CHOICE;
                    }
                    break;
            }
            return MemberVerificationFieldType.UNKNOWN;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final Object getResponse() {
            return this.response;
        }

        public final List<String> getValues() {
            return this.values;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.fieldType;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.label;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.required;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            List<String> list = this.values;
            int iHashCode3 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
            List<String> list2 = this.choices;
            int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Object obj = this.response;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }

        public final void setResponse(Object obj) {
            Intrinsics3.checkNotNullParameter(obj, "<set-?>");
            this.response = obj;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FormField(fieldType=");
            sbU.append(this.fieldType);
            sbU.append(", label=");
            sbU.append(this.label);
            sbU.append(", required=");
            sbU.append(this.required);
            sbU.append(", values=");
            sbU.append(this.values);
            sbU.append(", choices=");
            sbU.append(this.choices);
            sbU.append(", response=");
            sbU.append(this.response);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ModelMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm$MemberVerificationFieldType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TERMS", "TEXT_INPUT", "PARAGRAPH", "MULTIPLE_CHOICE", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public enum MemberVerificationFieldType {
        UNKNOWN,
        TERMS,
        TEXT_INPUT,
        PARAGRAPH,
        MULTIPLE_CHOICE
    }

    /* compiled from: ModelMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelMemberVerificationForm;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelMemberVerificationForm;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelMemberVerificationForm> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelMemberVerificationForm parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelMemberVerificationForm parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextObject(new ModelMemberVerificationForm3(ref$ObjectRefC0, reader, ref$ObjectRef));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("version");
            }
            String str = (String) t;
            T t2 = ref$ObjectRef.element;
            if (t2 == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("formFields");
            }
            return new ModelMemberVerificationForm(str, (List) t2);
        }
    }

    public ModelMemberVerificationForm(String str, List<FormField> list) {
        Intrinsics3.checkNotNullParameter(str, "version");
        Intrinsics3.checkNotNullParameter(list, "formFields");
        this.version = str;
        this.formFields = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelMemberVerificationForm copy$default(ModelMemberVerificationForm modelMemberVerificationForm, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelMemberVerificationForm.version;
        }
        if ((i & 2) != 0) {
            list = modelMemberVerificationForm.formFields;
        }
        return modelMemberVerificationForm.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<FormField> component2() {
        return this.formFields;
    }

    public final ModelMemberVerificationForm copy(String version, List<FormField> formFields) {
        Intrinsics3.checkNotNullParameter(version, "version");
        Intrinsics3.checkNotNullParameter(formFields, "formFields");
        return new ModelMemberVerificationForm(version, formFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMemberVerificationForm)) {
            return false;
        }
        ModelMemberVerificationForm modelMemberVerificationForm = (ModelMemberVerificationForm) other;
        return Intrinsics3.areEqual(this.version, modelMemberVerificationForm.version) && Intrinsics3.areEqual(this.formFields, modelMemberVerificationForm.formFields);
    }

    public final List<FormField> getFormFields() {
        return this.formFields;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FormField> list = this.formFields;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isFormOutdated() {
        List<FormField> list = this.formFields;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((FormField) it.next()).getMemberVerificationFieldType() == MemberVerificationFieldType.UNKNOWN) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelMemberVerificationForm(version=");
        sbU.append(this.version);
        sbU.append(", formFields=");
        return outline.L(sbU, this.formFields, ")");
    }
}
