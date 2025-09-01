package com.discord.models.commands;

import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommandOption.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\f\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J¨\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00102\b\b\u0002\u0010$\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b)\u0010\u0007J\u0010\u0010*\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001b\u0010&\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010/\u001a\u0004\b0\u0010\u0019R!\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b2\u0010\u0012R\u0019\u0010$\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00103\u001a\u0004\b4\u0010\u000eR!\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b#\u00101\u001a\u0004\b5\u0010\u0012R\u0019\u0010\u001f\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b6\u0010\u000eR\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b9\u0010\u0007R!\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b:\u0010\u0012R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010;\u001a\u0004\b<\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010=\u001a\u0004\b>\u0010\u000bR\u0019\u0010 \u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b?\u0010\u000eR\u001b\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010/\u001a\u0004\b@\u0010\u0019¨\u0006C"}, d2 = {"Lcom/discord/models/commands/ApplicationCommandOption;", "", "Lcom/discord/api/commands/ApplicationCommandType;", "component1", "()Lcom/discord/api/commands/ApplicationCommandType;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/lang/Integer;", "", "component5", "()Z", "component6", "", "component7", "()Ljava/util/List;", "Lcom/discord/api/commands/CommandChoice;", "component8", "component9", "component10", "", "component11", "()Ljava/lang/Number;", "component12", "type", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "descriptionRes", "required", "default", "channelTypes", "choices", "options", "autocomplete", "minValue", "maxValue", "copy", "(Lcom/discord/api/commands/ApplicationCommandType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZLjava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/lang/Number;Ljava/lang/Number;)Lcom/discord/models/commands/ApplicationCommandOption;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Number;", "getMaxValue", "Ljava/util/List;", "getChannelTypes", "Z", "getAutocomplete", "getOptions", "getRequired", "Ljava/lang/String;", "getName", "getDescription", "getChoices", "Lcom/discord/api/commands/ApplicationCommandType;", "getType", "Ljava/lang/Integer;", "getDescriptionRes", "getDefault", "getMinValue", "<init>", "(Lcom/discord/api/commands/ApplicationCommandType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZLjava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/lang/Number;Ljava/lang/Number;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandOption {
    private final boolean autocomplete;
    private final List<Integer> channelTypes;
    private final List<CommandChoice> choices;
    private final boolean default;
    private final String description;
    private final Integer descriptionRes;
    private final Number maxValue;
    private final Number minValue;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final boolean required;
    private final ApplicationCommandType type;

    public ApplicationCommandOption(ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List<Integer> list, List<CommandChoice> list2, List<ApplicationCommandOption> list3, boolean z4, Number number, Number number2) {
        Intrinsics3.checkNotNullParameter(applicationCommandType, "type");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.type = applicationCommandType;
        this.name = str;
        this.description = str2;
        this.descriptionRes = num;
        this.required = z2;
        this.default = z3;
        this.channelTypes = list;
        this.choices = list2;
        this.options = list3;
        this.autocomplete = z4;
        this.minValue = number;
        this.maxValue = number2;
    }

    public static /* synthetic */ ApplicationCommandOption copy$default(ApplicationCommandOption applicationCommandOption, ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List list, List list2, List list3, boolean z4, Number number, Number number2, int i, Object obj) {
        return applicationCommandOption.copy((i & 1) != 0 ? applicationCommandOption.type : applicationCommandType, (i & 2) != 0 ? applicationCommandOption.name : str, (i & 4) != 0 ? applicationCommandOption.description : str2, (i & 8) != 0 ? applicationCommandOption.descriptionRes : num, (i & 16) != 0 ? applicationCommandOption.required : z2, (i & 32) != 0 ? applicationCommandOption.default : z3, (i & 64) != 0 ? applicationCommandOption.channelTypes : list, (i & 128) != 0 ? applicationCommandOption.choices : list2, (i & 256) != 0 ? applicationCommandOption.options : list3, (i & 512) != 0 ? applicationCommandOption.autocomplete : z4, (i & 1024) != 0 ? applicationCommandOption.minValue : number, (i & 2048) != 0 ? applicationCommandOption.maxValue : number2);
    }

    /* renamed from: component1, reason: from getter */
    public final ApplicationCommandType getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    /* renamed from: component11, reason: from getter */
    public final Number getMinValue() {
        return this.minValue;
    }

    /* renamed from: component12, reason: from getter */
    public final Number getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final List<Integer> component7() {
        return this.channelTypes;
    }

    public final List<CommandChoice> component8() {
        return this.choices;
    }

    public final List<ApplicationCommandOption> component9() {
        return this.options;
    }

    public final ApplicationCommandOption copy(ApplicationCommandType type, String name, String description, Integer descriptionRes, boolean required, boolean z2, List<Integer> channelTypes, List<CommandChoice> choices, List<ApplicationCommandOption> options, boolean autocomplete, Number minValue, Number maxValue) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandOption(type, name, description, descriptionRes, required, z2, channelTypes, choices, options, autocomplete, minValue, maxValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandOption)) {
            return false;
        }
        ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) other;
        return Intrinsics3.areEqual(this.type, applicationCommandOption.type) && Intrinsics3.areEqual(this.name, applicationCommandOption.name) && Intrinsics3.areEqual(this.description, applicationCommandOption.description) && Intrinsics3.areEqual(this.descriptionRes, applicationCommandOption.descriptionRes) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && Intrinsics3.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && Intrinsics3.areEqual(this.choices, applicationCommandOption.choices) && Intrinsics3.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && Intrinsics3.areEqual(this.minValue, applicationCommandOption.minValue) && Intrinsics3.areEqual(this.maxValue, applicationCommandOption.maxValue);
    }

    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    public final List<Integer> getChannelTypes() {
        return this.channelTypes;
    }

    public final List<CommandChoice> getChoices() {
        return this.choices;
    }

    public final boolean getDefault() {
        return this.default;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    public final Number getMaxValue() {
        return this.maxValue;
    }

    public final Number getMinValue() {
        return this.minValue;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandOption> getOptions() {
        return this.options;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final ApplicationCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ApplicationCommandType applicationCommandType = this.type;
        int iHashCode = (applicationCommandType != null ? applicationCommandType.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.descriptionRes;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.default;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        List<Integer> list = this.channelTypes;
        int iHashCode5 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        List<CommandChoice> list2 = this.choices;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list3 = this.options;
        int iHashCode7 = (iHashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z4 = this.autocomplete;
        int i5 = (iHashCode7 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        Number number = this.minValue;
        int iHashCode8 = (i5 + (number != null ? number.hashCode() : 0)) * 31;
        Number number2 = this.maxValue;
        return iHashCode8 + (number2 != null ? number2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandOption(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", descriptionRes=");
        sbU.append(this.descriptionRes);
        sbU.append(", required=");
        sbU.append(this.required);
        sbU.append(", default=");
        sbU.append(this.default);
        sbU.append(", channelTypes=");
        sbU.append(this.channelTypes);
        sbU.append(", choices=");
        sbU.append(this.choices);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", autocomplete=");
        sbU.append(this.autocomplete);
        sbU.append(", minValue=");
        sbU.append(this.minValue);
        sbU.append(", maxValue=");
        sbU.append(this.maxValue);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ ApplicationCommandOption(ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List list, List list2, List list3, boolean z4, Number number, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommandType, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, z2, z3, (i & 64) != 0 ? Collections2.emptyList() : list, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? false : z4, (i & 1024) != 0 ? null : number, (i & 2048) != 0 ? null : number2);
    }
}
