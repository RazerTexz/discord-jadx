package b.g.a.c.z;

import b.g.a.a.JsonAutoDetect;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonIgnoreProperties;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonSetter;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyName;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.SimpleMixInResolver;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.e0.SubtypeResolver;
import b.g.a.c.i0.RootNameLookup;
import b.g.a.c.z.ConfigFeature;
import b.g.a.c.z.ConfigOverride;
import b.g.a.c.z.ContextAttributes;
import b.g.a.c.z.MapperConfigBase;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* compiled from: MapperConfigBase.java */
/* renamed from: b.g.a.c.z.m, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {
    public static final int j = MapperConfig.c(MapperFeature.class);
    public static final int k = (((MapperFeature.AUTO_DETECT_FIELDS.g() | MapperFeature.AUTO_DETECT_GETTERS.g()) | MapperFeature.AUTO_DETECT_IS_GETTERS.g()) | MapperFeature.AUTO_DETECT_SETTERS.g()) | MapperFeature.AUTO_DETECT_CREATORS.g();
    public final ContextAttributes _attributes;
    public final ConfigOverrides _configOverrides;
    public final SimpleMixInResolver _mixIns;
    public final PropertyName _rootName;
    public final RootNameLookup _rootNames;
    public final SubtypeResolver _subtypeResolver;
    public final Class<?> _view;

    public MapperConfigBase(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, j);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = subtypeResolver;
        this._rootNames = rootNameLookup;
        this._rootName = null;
        this._view = null;
        this._attributes = ContextAttributes.a.j;
        this._configOverrides = configOverrides;
    }

    @Override // b.g.a.c.c0.ClassIntrospector.a
    public final Class<?> a(Class<?> cls) {
        return this._mixIns.a(cls);
    }

    @Override // b.g.a.c.z.MapperConfig
    public final ConfigOverride f(Class<?> cls) {
        ConfigOverride configOverrideA = this._configOverrides.a(cls);
        return configOverrideA == null ? ConfigOverride.a.a : configOverrideA;
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonInclude.b g(Class<?> cls, Class<?> cls2) {
        this._configOverrides.a(cls2);
        JsonInclude.b bVarJ = j(cls);
        if (bVarJ == null) {
            return null;
        }
        return bVarJ.a(null);
    }

    @Override // b.g.a.c.z.MapperConfig
    public Boolean h() {
        return this._configOverrides._defaultMergeable;
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonFormat.d i(Class<?> cls) {
        ConfigOverrides configOverrides = this._configOverrides;
        Map<Class<?>, ?> map = configOverrides._overrides;
        if (map != null) {
        }
        Boolean bool = configOverrides._defaultLeniency;
        if (bool == null) {
            return JsonFormat.d.j;
        }
        return new JsonFormat.d("", null, null, null, null, JsonFormat.b.a, Boolean.valueOf(bool.booleanValue()));
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonInclude.b j(Class<?> cls) {
        this._configOverrides.a(cls);
        JsonInclude.b bVar = this._configOverrides._defaultInclusion;
        if (bVar == null) {
            return null;
        }
        return bVar.a(null);
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonSetter.a l() {
        return this._configOverrides._defaultSetterInfo;
    }

    @Override // b.g.a.c.z.MapperConfig
    public final VisibilityChecker<?> m(Class<?> cls, AnnotatedClass annotatedClass) {
        JsonAutoDetect.a aVar = JsonAutoDetect.a.NONE;
        VisibilityChecker<?> visibilityChecker = this._configOverrides._visibilityChecker;
        int i = this._mapperFeatures;
        int i2 = k;
        VisibilityChecker<?> aVar2 = visibilityChecker;
        if ((i & i2) != i2) {
            VisibilityChecker<?> aVar3 = visibilityChecker;
            if (!q(MapperFeature.AUTO_DETECT_FIELDS)) {
                VisibilityChecker.a aVar4 = (VisibilityChecker.a) visibilityChecker;
                JsonAutoDetect.a aVar5 = aVar4._fieldMinLevel;
                aVar3 = aVar4;
                if (aVar5 != aVar) {
                    aVar3 = new VisibilityChecker.a(aVar4._getterMinLevel, aVar4._isGetterMinLevel, aVar4._setterMinLevel, aVar4._creatorMinLevel, aVar);
                }
            }
            VisibilityChecker<?> aVar6 = aVar3;
            if (!q(MapperFeature.AUTO_DETECT_GETTERS)) {
                VisibilityChecker.a aVar7 = (VisibilityChecker.a) aVar3;
                JsonAutoDetect.a aVar8 = aVar7._getterMinLevel;
                aVar6 = aVar7;
                if (aVar8 != aVar) {
                    aVar6 = new VisibilityChecker.a(aVar, aVar7._isGetterMinLevel, aVar7._setterMinLevel, aVar7._creatorMinLevel, aVar7._fieldMinLevel);
                }
            }
            VisibilityChecker<?> aVar9 = aVar6;
            if (!q(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
                VisibilityChecker.a aVar10 = (VisibilityChecker.a) aVar6;
                JsonAutoDetect.a aVar11 = aVar10._isGetterMinLevel;
                aVar9 = aVar10;
                if (aVar11 != aVar) {
                    aVar9 = new VisibilityChecker.a(aVar10._getterMinLevel, aVar, aVar10._setterMinLevel, aVar10._creatorMinLevel, aVar10._fieldMinLevel);
                }
            }
            VisibilityChecker<?> aVar12 = aVar9;
            if (!q(MapperFeature.AUTO_DETECT_SETTERS)) {
                VisibilityChecker.a aVar13 = (VisibilityChecker.a) aVar9;
                JsonAutoDetect.a aVar14 = aVar13._setterMinLevel;
                aVar12 = aVar13;
                if (aVar14 != aVar) {
                    aVar12 = new VisibilityChecker.a(aVar13._getterMinLevel, aVar13._isGetterMinLevel, aVar, aVar13._creatorMinLevel, aVar13._fieldMinLevel);
                }
            }
            aVar2 = aVar12;
            if (!q(MapperFeature.AUTO_DETECT_CREATORS)) {
                VisibilityChecker.a aVar15 = (VisibilityChecker.a) aVar12;
                JsonAutoDetect.a aVar16 = aVar15._creatorMinLevel;
                aVar2 = aVar15;
                if (aVar16 != aVar) {
                    aVar2 = new VisibilityChecker.a(aVar15._getterMinLevel, aVar15._isGetterMinLevel, aVar15._setterMinLevel, aVar, aVar15._fieldMinLevel);
                }
            }
        }
        AnnotationIntrospector annotationIntrospectorE = e();
        VisibilityChecker<?> visibilityCheckerB = aVar2;
        if (annotationIntrospectorE != null) {
            visibilityCheckerB = annotationIntrospectorE.b(annotatedClass, aVar2);
        }
        if (this._configOverrides.a(cls) == null) {
            return visibilityCheckerB;
        }
        VisibilityChecker.a aVar17 = (VisibilityChecker.a) visibilityCheckerB;
        Objects.requireNonNull(aVar17);
        return aVar17;
    }

    public abstract T r(int i);

    public final JsonIgnoreProperties.a s(Class<?> cls, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospectorE = e();
        JsonIgnoreProperties.a aVarX = annotationIntrospectorE == null ? null : annotationIntrospectorE.x(this, annotatedClass);
        this._configOverrides.a(cls);
        JsonIgnoreProperties.a aVar = JsonIgnoreProperties.a.j;
        if (aVarX == null) {
            return null;
        }
        return aVarX;
    }

    public final T t(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mapperFeature : mapperFeatureArr) {
            i &= ~mapperFeature.g();
        }
        return i == this._mapperFeatures ? this : (T) r(i);
    }

    public MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, int i) {
        super(mapperConfigBase, i);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
    }
}
