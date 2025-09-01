package com.discord.models.commands;

import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelApplicationComparator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/models/commands/ModelApplicationComparator;", "", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ModelApplicationComparator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ModelApplicationComparator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/models/commands/ModelApplicationComparator$Companion;", "Ljava/util/Comparator;", "Lcom/discord/models/commands/Application;", "Lkotlin/Comparator;", "a", "b", "", "compare", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/Application;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion implements Comparator<Application> {
        private Companion() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Application application, Application application2) {
            return compare2(application, application2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Application a, Application b2) {
            Intrinsics3.checkNotNullParameter(a, "a");
            Intrinsics3.checkNotNullParameter(b2, "b");
            int i = (a.getBuiltIn() ? 1 : 0) - (b2.getBuiltIn() ? 1 : 0);
            return i != 0 ? i : a.getName().compareTo(b2.getName());
        }
    }
}
