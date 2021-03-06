# Generated by Django 3.0.3 on 2022-02-14 16:23

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Customer',
            fields=[
                ('cusid', models.AutoField(primary_key=True, serialize=False)),
                ('name', models.CharField(max_length=25)),
                ('phone', models.CharField(max_length=15)),
                ('email', models.CharField(max_length=25)),
                ('dob', models.CharField(max_length=25)),
                ('nominee', models.CharField(max_length=25)),
                ('nph', models.CharField(max_length=15)),
                ('address', models.CharField(max_length=100)),
                ('pin', models.CharField(max_length=8)),
                ('dist', models.CharField(max_length=25)),
                ('acc', models.CharField(max_length=25)),
                ('jdate', models.DateField()),
                ('lid', models.IntegerField()),
                ('aadr', models.CharField(max_length=20)),
            ],
            options={
                'db_table': 'customer',
                'managed': False,
            },
        ),
    ]
