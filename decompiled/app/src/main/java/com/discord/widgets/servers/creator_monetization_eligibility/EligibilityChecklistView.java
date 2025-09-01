package com.discord.widgets.servers.creator_monetization_eligibility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewEligibilityChecklistRowBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EligibilityChecklistView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/EligibilityChecklistView;", "Landroid/widget/LinearLayout;", "", "onFinishInflate", "()V", "", "Lcom/discord/widgets/servers/creator_monetization_eligibility/EligibilityChecklistView$Requirement;", "requirements", "bind", "(Ljava/util/List;)V", "lastRequirements", "Ljava/util/List;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Requirement", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EligibilityChecklistView extends LinearLayout {
    private List<Requirement> lastRequirements;

    /* compiled from: EligibilityChecklistView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/EligibilityChecklistView$Requirement;", "", "", "component1", "()Ljava/lang/CharSequence;", "component2", "", "component3", "()Z", "title", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "isMet", "copy", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Lcom/discord/widgets/servers/creator_monetization_eligibility/EligibilityChecklistView$Requirement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getDescription", "Z", "getTitle", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Requirement {
        private final CharSequence description;
        private final boolean isMet;
        private final CharSequence title;

        public Requirement(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
            Intrinsics3.checkNotNullParameter(charSequence, "title");
            Intrinsics3.checkNotNullParameter(charSequence2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            this.title = charSequence;
            this.description = charSequence2;
            this.isMet = z2;
        }

        public static /* synthetic */ Requirement copy$default(Requirement requirement, CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = requirement.title;
            }
            if ((i & 2) != 0) {
                charSequence2 = requirement.description;
            }
            if ((i & 4) != 0) {
                z2 = requirement.isMet;
            }
            return requirement.copy(charSequence, charSequence2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMet() {
            return this.isMet;
        }

        public final Requirement copy(CharSequence title, CharSequence description, boolean isMet) {
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            return new Requirement(title, description, isMet);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Requirement)) {
                return false;
            }
            Requirement requirement = (Requirement) other;
            return Intrinsics3.areEqual(this.title, requirement.title) && Intrinsics3.areEqual(this.description, requirement.description) && this.isMet == requirement.isMet;
        }

        public final CharSequence getDescription() {
            return this.description;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            CharSequence charSequence = this.title;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.description;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            boolean z2 = this.isMet;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isMet() {
            return this.isMet;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Requirement(title=");
            sbU.append(this.title);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", isMet=");
            return outline.O(sbU, this.isMet, ")");
        }
    }

    public EligibilityChecklistView(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ EligibilityChecklistView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bind(List<Requirement> requirements) {
        Intrinsics3.checkNotNullParameter(requirements, "requirements");
        if (Intrinsics3.areEqual(requirements, this.lastRequirements)) {
            return;
        }
        removeAllViews();
        Drawable colorDrawable = new ColorDrawable(ColorCompat.getThemedColor(this, R.attr.colorBackgroundAccent));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        boolean z2 = true;
        for (Requirement requirement : requirements) {
            if (z2) {
                z2 = false;
            } else {
                View view = new View(getContext());
                view.setBackground(colorDrawable);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, DimenUtils.dpToPixels(1));
                marginLayoutParams.leftMargin = DimenUtils.dpToPixels(16);
                marginLayoutParams.rightMargin = DimenUtils.dpToPixels(16);
                view.setLayoutParams(marginLayoutParams);
                addView(view);
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_eligibility_checklist_row, (ViewGroup) null, false);
            int i = R.id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.description);
            if (linkifiedTextView != null) {
                i = R.id.eligibility_indicator;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.eligibility_indicator);
                if (imageView != null) {
                    i = R.id.title;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.title);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new ViewEligibilityChecklistRowBinding(constraintLayout, linkifiedTextView, imageView, textView), "ViewEligibilityChecklist…g.inflate(layoutInflater)");
                        Intrinsics3.checkNotNullExpressionValue(imageView, "eligibilityIndicator");
                        imageView.setActivated(requirement.isMet());
                        Intrinsics3.checkNotNullExpressionValue(textView, "title");
                        textView.setText(requirement.getTitle());
                        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                        linkifiedTextView.setText(requirement.getDescription());
                        addView(constraintLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        setOrientation(1);
        if (isInEditMode()) {
            CharSequence charSequenceJ = FormatUtils.j(this, R.string.guild_role_subscription_settings_eligibility_requirement_members_eligible, new Object[]{50}, null, 4);
            String string = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_description);
            Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(\n   …cription,\n              )");
            String string2 = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_eligible);
            Intrinsics3.checkNotNullExpressionValue(string2, "resources.getString(\n   …_eligible\n              )");
            String string3 = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_description);
            Intrinsics3.checkNotNullExpressionValue(string3, "resources.getString(\n   …cription,\n              )");
            bind(Collections2.listOf((Object[]) new Requirement[]{new Requirement(charSequenceJ, string, true), new Requirement(string2, string3, true)}));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EligibilityChecklistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.lastRequirements = Collections2.emptyList();
    }
}
