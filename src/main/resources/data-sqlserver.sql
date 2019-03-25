PRINT 'Start of Script Execution....';
GO

IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[createProject]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[createProject]
END
GO

CREATE PROCEDURE [dbo].[createProject]
(
	@name VARCHAR(50),
	@description VARCHAR(200)
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

IF(@name = '' OR @name IS NULL)
	BEGIN
		PRINT 'The name cant be empty or null!';
		RETURN;
	END

IF(@description = '' OR @description IS NULL)
	BEGIN
		PRINT 'The description cant be empty or null!';
		RETURN;
	END


INSERT INTO [dbo].[project](name, description, created_at, version)
VALUES (@name, @description, GETDATE(), 0);

SELECT * FROM [dbo].[project] WHERE id = SCOPE_IDENTITY();

PRINT 'project created successfully!'


GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[readProject]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[readProject]
END
GO

CREATE PROCEDURE [dbo].[readProject]

AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

SELECT *
FROM project

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[updateProject]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[updateProject]
END
GO

CREATE PROCEDURE [dbo].[updateProject]
(
	@id BIGINT,
	@name VARCHAR(50),
	@description VARCHAR(200)
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

UPDATE [dbo].[project]
SET name = @name, description = @description
WHERE id = @id

SELECT * FROM [dbo].[project] WHERE id = @id;

PRINT 'project updated successfully!'

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[deleteProject]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[deleteProject]
END
GO

CREATE PROCEDURE [dbo].[deleteProject]
(
	@id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

DELETE [dbo].[project]
WHERE id = @id

GO

PRINT 'Start of Script Execution....';
GO

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[createRol]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[createRol]
	END
GO

CREATE PROCEDURE [dbo].[createRol]
(
	@name VARCHAR(50)
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

IF(@name = '' OR @name IS NULL)
	BEGIN
		PRINT 'The name cant be empty or null!';
		RETURN;
	END

INSERT INTO [dbo].[rol](name, created_at, version)
VALUES (@name, GETDATE(), 0);

SELECT * FROM [dbo].[rol] WHERE id = SCOPE_IDENTITY();

PRINT 'Rol created successfully!'


GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[readRol]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[readRol]
	END
GO

CREATE PROCEDURE [dbo].[readRol]

AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

SELECT *
FROM rol

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[updateRol]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[updateRol]
	END
GO

CREATE PROCEDURE [dbo].[updateRol]
(
	@id BIGINT,
	@name VARCHAR(50)
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

UPDATE [dbo].[rol]
SET name = @name
WHERE id = @id

SELECT * FROM [dbo].[rol] WHERE id = @id;

PRINT 'Rol updated successfully!'

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[deleteRol]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[deleteRol]
	END
GO

CREATE PROCEDURE [dbo].[deleteRol]
(
	@id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

DELETE [dbo].[rol]
WHERE id = @id

GO

PRINT 'Start of Script Execution....';
GO

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[createWorker]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[createWorker]
	END
GO

CREATE PROCEDURE [dbo].[createWorker]
(
	@first_name VARCHAR(50),
	@last_name VARCHAR(50),
	@hiring_date DATETIME,
	@rol_id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

IF(@first_name = '' OR @first_name IS NULL)
	BEGIN
		PRINT 'The first_name cant be empty or null!';
		RETURN;
	END

IF(@last_name = '' OR @last_name IS NULL)
	BEGIN
		PRINT 'The last_name cant be empty or null!';
		RETURN;
	END


INSERT INTO [dbo].[worker](first_name, last_name, hiring_date, created_at, version, rol_id)
VALUES (@first_name, @last_name, @hiring_date, GETDATE(), 0, @rol_id);

SELECT * FROM [dbo].[worker] WHERE id = SCOPE_IDENTITY();

PRINT 'Worker created successfully!'


GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[readWorker]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[readWorker]
	END
GO

CREATE PROCEDURE [dbo].[readWorker]

AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

SELECT *
FROM worker

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[updateWorker]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[updateWorker]
	END
GO

CREATE PROCEDURE [dbo].[updateWorker]
(
	@id BIGINT,
	@first_name VARCHAR(50),
	@last_name VARCHAR(50),
	@hiring_date DATETIME,
	@rol_id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

UPDATE [dbo].[worker]
SET first_name = @first_name, last_name = @last_name, hiring_date = @hiring_date, rol_id = @rol_id
WHERE id = @id

SELECT * FROM [dbo].[worker] WHERE id = @id;

PRINT 'Worker updated successfully!'

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[deleteWorker]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[deleteWorker]
	END
GO

CREATE PROCEDURE [dbo].[deleteWorker]
(
	@id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

DELETE [dbo].[worker]
WHERE id = @id

GO

PRINT 'Start of Script Execution....';
GO

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[createActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[createActivity]
	END
GO

CREATE PROCEDURE [dbo].[createActivity]
(
	@activity_name VARCHAR(50)
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

IF(@activity_name = '' OR @activity_name IS NULL)
	BEGIN
		PRINT 'The activity_name cant be empty or null!';
		RETURN;
	END

INSERT INTO [dbo].[activity](activity_name, created_at, version)
VALUES (@activity_name, GETDATE(), 0);

SELECT * FROM [dbo].[activity] WHERE id = SCOPE_IDENTITY();

PRINT 'Activity created successfully!'


GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[readActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[readActivity]
	END
GO

CREATE PROCEDURE [dbo].[readActivity]

AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

SELECT *
FROM activity

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[updateActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[updateActivity]
	END
GO

CREATE PROCEDURE [dbo].[updateActivity]
(
	@id BIGINT,
	@activity_name VARCHAR(50)
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

UPDATE [dbo].[activity]
SET activity_name = @activity_name
WHERE id = @id

SELECT * FROM [dbo].[activity] WHERE id = @id;

PRINT 'Activity updated successfully!'

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[deleteActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[deleteActivity]
	END
GO

CREATE PROCEDURE [dbo].[deleteActivity]
(
	@id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

DELETE [dbo].[activity]
WHERE id = @id

GO

PRINT 'Start of Script Execution....';
GO

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[createDetailActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[createDetailActivity]
	END
GO

CREATE PROCEDURE [dbo].[createDetailActivity]
(
	@activity_id BIGINT,
	@project_id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;


INSERT INTO [dbo].[detail_activity](activity_id, project_id, created_at, version)
VALUES (@activity_id, @project_id, GETDATE(), 0);

SELECT * FROM [dbo].[detail_activity] WHERE id = SCOPE_IDENTITY();

PRINT 'DetailActivity created successfully!'


GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[readDetailActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[readDetailActivity]
	END
GO

CREATE PROCEDURE [dbo].[readDetailActivity]

AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

SELECT *
FROM detail_activity

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[updateDetailActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[updateDetailActivity]
	END
GO

CREATE PROCEDURE [dbo].[updateDetailActivity]
(
	@id BIGINT,
	@activity_id BIGINT,
	@project_id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

UPDATE [dbo].[detail_activity]
SET activity_id = @activity_id, project_id = @project_id
WHERE id = @id

SELECT * FROM [dbo].[detail_activity] WHERE id = @id;

PRINT 'DetailActivity updated successfully!'

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[deleteDetailActivity]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[deleteDetailActivity]
	END
GO

CREATE PROCEDURE [dbo].[deleteDetailActivity]
(
	@id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

DELETE [dbo].[detail_activity]
WHERE id = @id

GO

PRINT 'Start of Script Execution....';
GO

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[createAsignation]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[createAsignation]
	END
GO

CREATE PROCEDURE [dbo].[createAsignation]
(
	@detail_activity_id BIGINT,
	@worker_id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;


INSERT INTO [dbo].[asignation](detail_activity_id, worker_id, created_at, version)
VALUES (@detail_activity_id, @worker_id, GETDATE(), 0);

SELECT * FROM [dbo].[asignation] WHERE id = SCOPE_IDENTITY();

PRINT 'Asignation created successfully!'


GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[readAsignation]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[readAsignation]
	END
GO

CREATE PROCEDURE [dbo].[readAsignation]

AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

SELECT *
FROM asignation

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[updateAsignation]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[updateAsignation]
	END
GO

CREATE PROCEDURE [dbo].[updateAsignation]
(
	@id BIGINT,
	@detail_activity_id BIGINT,
	@worker_id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

UPDATE [dbo].[asignation]
SET detail_activity_id = @detail_activity_id, worker_id = @worker_id
WHERE id = @id

SELECT * FROM [dbo].[asignation] WHERE id = @id;

PRINT 'Asignation updated successfully!'

GO

----------------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.objects
					 WHERE object_id = OBJECT_ID(N'[dbo].[deleteAsignation]')
						 AND type in (N'P', N'PC'))
	BEGIN
		DROP PROCEDURE [dbo].[deleteAsignation]
	END
GO

CREATE PROCEDURE [dbo].[deleteAsignation]
(
	@id BIGINT
)
AS

SET XACT_ABORT ON;
SET NOCOUNT ON;

DELETE [dbo].[asignation]
WHERE id = @id

GO
