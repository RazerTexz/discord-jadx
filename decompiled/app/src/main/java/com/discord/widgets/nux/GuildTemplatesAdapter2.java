package com.discord.widgets.nux;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildTemplatesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateViewType;", "", "", "viewType", "I", "getViewType", "()I", "<init>", "(I)V", "Companion", "Template", "Text", "Lcom/discord/widgets/nux/GuildTemplateViewType$Text;", "Lcom/discord/widgets/nux/GuildTemplateViewType$Template;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildTemplateViewType, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class GuildTemplatesAdapter2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TEMPLATE = 1;
    private static final int TEXT = 0;
    private final int viewType;

    /* compiled from: GuildTemplatesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateViewType$Companion;", "", "", "TEXT", "I", "getTEXT", "()I", "TEMPLATE", "getTEMPLATE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.GuildTemplateViewType$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final int getTEMPLATE() {
            return GuildTemplatesAdapter2.access$getTEMPLATE$cp();
        }

        public final int getTEXT() {
            return GuildTemplatesAdapter2.access$getTEXT$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildTemplatesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateViewType$Template;", "Lcom/discord/widgets/nux/GuildTemplateViewType;", "Lcom/discord/widgets/nux/GuildTemplate;", "component1", "()Lcom/discord/widgets/nux/GuildTemplate;", "guildTemplate", "copy", "(Lcom/discord/widgets/nux/GuildTemplate;)Lcom/discord/widgets/nux/GuildTemplateViewType$Template;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/nux/GuildTemplate;", "getGuildTemplate", "<init>", "(Lcom/discord/widgets/nux/GuildTemplate;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.GuildTemplateViewType$Template */
    public static final /* data */ class Template extends GuildTemplatesAdapter2 {
        private final GuildTemplates guildTemplate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Template(GuildTemplates guildTemplates) {
            super(GuildTemplatesAdapter2.INSTANCE.getTEMPLATE(), null);
            Intrinsics3.checkNotNullParameter(guildTemplates, "guildTemplate");
            this.guildTemplate = guildTemplates;
        }

        public static /* synthetic */ Template copy$default(Template template, GuildTemplates guildTemplates, int i, Object obj) {
            if ((i & 1) != 0) {
                guildTemplates = template.guildTemplate;
            }
            return template.copy(guildTemplates);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildTemplates getGuildTemplate() {
            return this.guildTemplate;
        }

        public final Template copy(GuildTemplates guildTemplate) {
            Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
            return new Template(guildTemplate);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Template) && Intrinsics3.areEqual(this.guildTemplate, ((Template) other).guildTemplate);
            }
            return true;
        }

        public final GuildTemplates getGuildTemplate() {
            return this.guildTemplate;
        }

        public int hashCode() {
            GuildTemplates guildTemplates = this.guildTemplate;
            if (guildTemplates != null) {
                return guildTemplates.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Template(guildTemplate=");
            sbU.append(this.guildTemplate);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildTemplatesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateViewType$Text;", "Lcom/discord/widgets/nux/GuildTemplateViewType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.GuildTemplateViewType$Text */
    public static final class Text extends GuildTemplatesAdapter2 {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(GuildTemplatesAdapter2.INSTANCE.getTEXT(), null);
        }
    }

    private GuildTemplatesAdapter2(int i) {
        this.viewType = i;
    }

    public static final /* synthetic */ int access$getTEMPLATE$cp() {
        return TEMPLATE;
    }

    public static final /* synthetic */ int access$getTEXT$cp() {
        return TEXT;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ GuildTemplatesAdapter2(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
