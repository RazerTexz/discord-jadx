package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApplicationCommandOption.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\u0019\u0010!\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00158\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u001b\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010)\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR!\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\u0019\u0010-\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010\u0004¨\u0006/"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandOption;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "required", "Z", "j", "()Z", "Lcom/discord/api/commands/ApplicationCommandType;", "type", "Lcom/discord/api/commands/ApplicationCommandType;", "k", "()Lcom/discord/api/commands/ApplicationCommandType;", "", "channelTypes", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "maxValue", "Ljava/lang/Number;", "f", "()Ljava/lang/Number;", "default", "d", "autocomplete", "a", "Lcom/discord/api/commands/CommandChoice;", "choices", "c", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "Ljava/lang/String;", "e", "minValue", "g", "options", "i", ModelAuditLogEntry.CHANGE_KEY_NAME, "h", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandOption {
    private final boolean autocomplete;
    private final List<Integer> channelTypes;
    private final List<CommandChoice> choices;
    private final boolean default;
    private final String description;
    private final Number maxValue;
    private final Number minValue;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final boolean required;
    private final ApplicationCommandType type;

    /* renamed from: a, reason: from getter */
    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    public final List<Integer> b() {
        return this.channelTypes;
    }

    public final List<CommandChoice> c() {
        return this.choices;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* renamed from: e, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandOption)) {
            return false;
        }
        ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) other;
        return Intrinsics3.areEqual(this.type, applicationCommandOption.type) && Intrinsics3.areEqual(this.name, applicationCommandOption.name) && Intrinsics3.areEqual(this.description, applicationCommandOption.description) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && Intrinsics3.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && Intrinsics3.areEqual(this.choices, applicationCommandOption.choices) && Intrinsics3.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && Intrinsics3.areEqual(this.minValue, applicationCommandOption.minValue) && Intrinsics3.areEqual(this.maxValue, applicationCommandOption.maxValue);
    }

    /* renamed from: f, reason: from getter */
    public final Number getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: g, reason: from getter */
    public final Number getMinValue() {
        return this.minValue;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ApplicationCommandType applicationCommandType = this.type;
        int iHashCode = (applicationCommandType != null ? applicationCommandType.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.default;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        List<Integer> list = this.channelTypes;
        int iHashCode4 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        List<CommandChoice> list2 = this.choices;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list3 = this.options;
        int iHashCode6 = (iHashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z4 = this.autocomplete;
        int i5 = (iHashCode6 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        Number number = this.minValue;
        int iHashCode7 = (i5 + (number != null ? number.hashCode() : 0)) * 31;
        Number number2 = this.maxValue;
        return iHashCode7 + (number2 != null ? number2.hashCode() : 0);
    }

    public final List<ApplicationCommandOption> i() {
        return this.options;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* renamed from: k, reason: from getter */
    public final ApplicationCommandType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandOption(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
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
}
