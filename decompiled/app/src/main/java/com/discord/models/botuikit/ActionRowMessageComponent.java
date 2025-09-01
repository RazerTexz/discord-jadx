package com.discord.models.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.Component6;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ActionRowMessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\f\b\u0002\u0010\u000f\u001a\u00060\tj\u0002`\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00060\tj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00062\f\b\u0002\u0010\u000f\u001a\u00060\tj\u0002`\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\fJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR \u0010\u000f\u001a\u00060\tj\u0002`\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001c\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/discord/models/botuikit/ActionRowMessageComponent;", "Lcom/discord/models/botuikit/LayoutMessageComponent;", "", "Lcom/discord/models/botuikit/MessageComponent;", "getChildren", "()Ljava/util/List;", "Lcom/discord/api/botuikit/ComponentType;", "component1", "()Lcom/discord/api/botuikit/ComponentType;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "component2", "()I", "component3", "type", "index", "components", "copy", "(Lcom/discord/api/botuikit/ComponentType;ILjava/util/List;)Lcom/discord/models/botuikit/ActionRowMessageComponent;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Ljava/util/List;", "getComponents", "Lcom/discord/api/botuikit/ComponentType;", "getType", "<init>", "(Lcom/discord/api/botuikit/ComponentType;ILjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ActionRowMessageComponent extends MessageComponent3 {
    private final List<MessageComponent> components;
    private final int index;
    private final Component6 type;

    public /* synthetic */ ActionRowMessageComponent(Component6 component6, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(component6, (i2 & 2) != 0 ? 0 : i, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionRowMessageComponent copy$default(ActionRowMessageComponent actionRowMessageComponent, Component6 component6, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            component6 = actionRowMessageComponent.getType();
        }
        if ((i2 & 2) != 0) {
            i = actionRowMessageComponent.getIndex();
        }
        if ((i2 & 4) != 0) {
            list = actionRowMessageComponent.components;
        }
        return actionRowMessageComponent.copy(component6, i, list);
    }

    public final Component6 component1() {
        return getType();
    }

    public final int component2() {
        return getIndex();
    }

    public final List<MessageComponent> component3() {
        return this.components;
    }

    public final ActionRowMessageComponent copy(Component6 type, int index, List<? extends MessageComponent> components) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(components, "components");
        return new ActionRowMessageComponent(type, index, components);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionRowMessageComponent)) {
            return false;
        }
        ActionRowMessageComponent actionRowMessageComponent = (ActionRowMessageComponent) other;
        return Intrinsics3.areEqual(getType(), actionRowMessageComponent.getType()) && getIndex() == actionRowMessageComponent.getIndex() && Intrinsics3.areEqual(this.components, actionRowMessageComponent.components);
    }

    @Override // com.discord.models.botuikit.MessageComponent3
    public List<MessageComponent> getChildren() {
        return this.components;
    }

    public final List<MessageComponent> getComponents() {
        return this.components;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public int getIndex() {
        return this.index;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public Component6 getType() {
        return this.type;
    }

    public int hashCode() {
        Component6 type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        List<MessageComponent> list = this.components;
        return index + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActionRowMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", components=");
        return outline.L(sbU, this.components, ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionRowMessageComponent(Component6 component6, int i, List<? extends MessageComponent> list) {
        Intrinsics3.checkNotNullParameter(component6, "type");
        Intrinsics3.checkNotNullParameter(list, "components");
        this.type = component6;
        this.index = i;
        this.components = list;
    }
}
