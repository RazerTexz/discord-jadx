package com.discord.widgets.chat.input;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatInputCategoriesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\t\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/input/CommandCategoryItem;", "", "Lcom/discord/models/commands/Application;", "component1", "()Lcom/discord/models/commands/Application;", "", "component2", "()Z", "application", "isSelected", "copy", "(Lcom/discord/models/commands/Application;Z)Lcom/discord/widgets/chat/input/CommandCategoryItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/Application;", "getApplication", "Z", "<init>", "(Lcom/discord/models/commands/Application;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.CommandCategoryItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatInputCategoriesAdapter3 {
    private final Application application;
    private final boolean isSelected;

    public WidgetChatInputCategoriesAdapter3(Application application, boolean z2) {
        Intrinsics3.checkNotNullParameter(application, "application");
        this.application = application;
        this.isSelected = z2;
    }

    public static /* synthetic */ WidgetChatInputCategoriesAdapter3 copy$default(WidgetChatInputCategoriesAdapter3 widgetChatInputCategoriesAdapter3, Application application, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = widgetChatInputCategoriesAdapter3.application;
        }
        if ((i & 2) != 0) {
            z2 = widgetChatInputCategoriesAdapter3.isSelected;
        }
        return widgetChatInputCategoriesAdapter3.copy(application, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final WidgetChatInputCategoriesAdapter3 copy(Application application, boolean isSelected) {
        Intrinsics3.checkNotNullParameter(application, "application");
        return new WidgetChatInputCategoriesAdapter3(application, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputCategoriesAdapter3)) {
            return false;
        }
        WidgetChatInputCategoriesAdapter3 widgetChatInputCategoriesAdapter3 = (WidgetChatInputCategoriesAdapter3) other;
        return Intrinsics3.areEqual(this.application, widgetChatInputCategoriesAdapter3.application) && this.isSelected == widgetChatInputCategoriesAdapter3.isSelected;
    }

    public final Application getApplication() {
        return this.application;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        boolean z2 = this.isSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CommandCategoryItem(application=");
        sbU.append(this.application);
        sbU.append(", isSelected=");
        return outline.O(sbU, this.isSelected, ")");
    }
}
